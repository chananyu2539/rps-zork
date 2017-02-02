package rps;


import java.util.*;

/**
 * Created by chananyu2539 on 1/12/2017 AD.
 */
public class Player {

    private int BAG_SIZE = 6;

    private Guardian target = null;

    private boolean canDebuff = false;

    public boolean isBattle = false;

    private final int[] fleePos = new int[2];

    private int x = 2;
    private int y = 0;
    private int floor = 1;

    private final Item[] itemBags = new Item[BAG_SIZE];

    private final ArrayList<String> questBag = new ArrayList<>();

    private int hp = 100;


    private int hasSilencePotion(){
        for (int i = 0; i < BAG_SIZE;i++){
            if(itemBags[i]!=null & itemBags[i].getName().equals("debuff potion")){
                return i;
            }
        }
        return -1;
    }

    public int useSilencePotion(){
        int itemSlot = hasSilencePotion();
        if(itemSlot==-1){
            return -2;
        }
        else {
            if (this.canDebuff) {
                return 0;
            }
             else {
                itemBags[itemSlot] = null;
                this.canDebuff = true;
                return 1;
            }
        }
    }

    private int hasHealPotion(){
        for (int i = 0; i < BAG_SIZE;i++){
            if(itemBags[i]!=null & itemBags[i].getName().equals("healing potion")){
                return i;
            }
        }
        return -1;
    }
    public int useHealPotion(){
        int itemSlot = hasHealPotion();
        if(itemSlot==-1){
            return -2;
        }
        else {
            if (this.hp == 100) {
                return 0;
            } else if (this.hp == 95) {
                itemBags[itemSlot] = null;
                this.hp += 5;
                return 1;
            } else {
                itemBags[itemSlot] = null;
                this.hp += 10;
                return 1;
            }
        }
    }



    private boolean isRoomValidMove(String dir){
        Room currentRoom = WorldMap.worldMap.get(floor)[x][y];
        return currentRoom.canGo(dir);
    }

    public int move(String dir){
        if(!isBattle){
            dir = dir.toLowerCase();
            if(isRoomValidMove(dir)){
                fleePos[0] = this.x;
                fleePos[1] = this.y;
                switch (dir){
                    case "north":
                        this.x-=1;
                    case "east":
                        this.y+=1;
                    case "west":
                        this.y-=1;
                    case "south":
                        this.x+=1;
                }
                return 1;
            }
            return -1;
        }
        return 0;

    }

    public int compareChoice(String player,String computer){
        if(player.equals(computer))
            return 0;

        if(player.equals("rock"))
            return (computer.equals("scissors") ? 1 : -1);
        if(player.equals("paper"))
            return (computer.equals("rock") ? 1 : -1);
        if(player.equals("scissors"))
            return (computer.equals("paper") ? 1 : -1);

        //should not reach here
        return -2;

    }

    public String genComputer(){
        int c = new Random().nextInt(3);

        switch (c){
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
        }

        return "shouldn't reach here";
    }

    public boolean validAttack(){
        Room currentRoom = WorldMap.worldMap.get(floor)[x][y];

        Guardian currentGuardian = currentRoom.getGuardian();

        if(currentGuardian!=null){
            this.target = currentGuardian;
            return true;
        }
        return false;
    }

    public int attackWith(String choice){
        if(this.isBattle) {
            choice = choice.toLowerCase();
            String enemy = genComputer();
            if(this.canDebuff){
                while (enemy.equals("rock")){
                    enemy = genComputer();
                }
            }
            int status = compareChoice(choice, enemy);
            if(status==1){
                this.target.lose();
                if(target.isDead()){
                    getCurrentRoom().setGuardian(null);
                }
                this.isBattle = false;
            }
            else if(status==-1){
                lose();

            }
            return status;
        }
        return -2;
    }

    private void lose() {
        this.hp -= 5;
    }

    public boolean canCollectItem(){
        for(int i = 0 ;i<6;i++){
            if (itemBags[i] == null){
                return true;
            }
        }
        return false;
    }

    private int isValidCollect(String item){
        Room currentRoom = WorldMap.worldMap.get(floor)[x][y];
        Item[] allItem = currentRoom.getItemList();
        for(int i = 0;i<allItem.length;i++){
            Item currentItem = allItem[i];
            if(currentItem!=null && item.equals(currentItem.getName())){
                return i;
            }
        }

        return -1;
    }

    public Room getCurrentRoom(){
        return WorldMap.worldMap.get(floor)[x][y];
    }


    public void dropItem(int i){
        itemBags[i] = null;
    }

    public int[] checkPos(){
        int[] pos = {this.x,this.y};
        return pos;
    }

    public String checkHP(){
        return ""+this.hp;
    }

    public String checkBag(){
        String rs = "";
        int slot = 1;
        for( Item item : itemBags){
            rs += slot + " =>" + item.getInfo()+"\n";
        }
        return rs;
    }


    public boolean isDead() {
        return this.hp <= 0;
    }
}
