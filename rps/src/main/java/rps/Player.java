package rps;


import java.util.*;

/**
 * Created by chananyu2539 on 1/12/2017 AD.
 */
public class Player {

    private int BAG_SIZE = 6;

    private WorldMap playerMap = new WorldMap();

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

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setFloor(int f){
        this.floor = f;
    }



    public int combineKey(){

        if(!getCurrentRoom().canProceed())
            return 0;
        if(questBag.contains("key1")&&questBag.contains("key2")){
            questBag.remove("key1");
            questBag.remove("key2");
            return 1;
        }
        else
            return -1;
    }

    public boolean flee(){
        if(this.isBattle){
            this.hp -= 5;
            this.target = null;
            this.x = fleePos[0];
            this.y = fleePos[1];
            this.isBattle = false;
            return true;
        }
        return false;
    }



    private int hasDebuffPotion(){
        for (int i = 0; i < BAG_SIZE;i++){
            if(itemBags[i]!=null && itemBags[i].getName().equals("debuff potion")){
                return i;
            }
        }
        return -1;
    }

    public int useDebuffPotion(){
        int itemSlot = hasDebuffPotion();
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
            if(itemBags[i]!=null && itemBags[i].getName().equals("healing potion")){
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
        Room currentRoom = this.playerMap.worldMap.get(floor)[x][y];
        return currentRoom.canGo(dir);
    }

    public int move(String dir){
        if(!isBattle){
            if(!getCurrentRoom().canProceed())
                return -2;
            dir = dir.toLowerCase();
            if(isRoomValidMove(dir)){
                fleePos[0] = this.x;
                fleePos[1] = this.y;

                if(dir.equals("north"))
                    this.x -= 1;
                else if(dir.equals("east"))
                    this.y+=1;
                else if(dir.equals("west"))
                    this.y-=1;
                else if(dir.equals("south"))
                    this.x+=1;

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
        Room currentRoom = this.playerMap.worldMap.get(floor)[x][y];

        Guardian currentGuardian = currentRoom.getGuardian();

        if(currentGuardian!=null){
            this.target = currentGuardian;
            this.isBattle = true;
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
            this.canDebuff=false;
            int status = compareChoice(choice, enemy);
            if(status==1){
                this.target.lose();
                if(target.isDead()){
                    getCurrentRoom().setGuardian(null);
                    this.isBattle = false;
                    return 4;
                }
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

    public int itemEmptySlot(){
        for(int i = 0 ;i<6;i++){
            if (itemBags[i] == null){
                return i;
            }
        }
        return -1;
    }

    private int isValidCollect(String item){
        Room currentRoom = this.playerMap.worldMap.get(floor)[x][y];
        Item[] allItem = currentRoom.getItemList();
        for(int i = 0;i<allItem.length;i++){
            Item currentItem = allItem[i];
            if(currentItem!=null && item.equals(currentItem.getName())){
                return i;
            }
        }

        return -1;
    }

    public int collect(String item,int i){
        int targetSlot = isValidCollect(item);
        if (targetSlot > -1) {
            Item[] roomItem = getCurrentRoom().getItemList();

            if(item.contains("potion")) {
                itemBags[i] = roomItem[targetSlot];
                roomItem[targetSlot] = null;
                return 1;
            }
            else {
                questBag.add(item);
                roomItem[targetSlot] = null;

                return 0;
            }

        }
        else {
            return -1;
        }
    }


    public Room getCurrentRoom(){
        return this.playerMap.worldMap.get(floor)[x][y];
    }


    public boolean dropItem(int i){
        if(itemBags[i]==null)
            return false;
        itemBags[i] = null;
        return true;
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
        int slot = 0;
        for( Item item : itemBags){
            if(item!=null)
                rs += slot + " =>" + item.getInfo()+"\n";
            slot+=1;
        }
        return rs;
    }


    public boolean canGoSecondFloor(){
        Room finalRoom = this.playerMap.getFirstBossRoom();
        return finalRoom.getGuardian()==null;
    }

    public void goSecondFloor(){
        this.floor = 2;
        this.x = 1;
        this.y = 1;

    }

    public int getFloor(){
        return this.floor;
    }


    public boolean isDead() {
        return this.hp <= 0;
    }

    public void goThirdFloor() {
        this.floor = 3;
        this.x = 1;
        this.y = 0;
    }

    public boolean clearFinalBoss() {
        Room lastRoom = this.playerMap.getLastBossRoom();
        return lastRoom.getGuardian()==null;
    }
}
