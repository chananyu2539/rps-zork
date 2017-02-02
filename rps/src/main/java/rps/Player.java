package rps;


import java.util.*;

/**
 * Created by chananyu2539 on 1/12/2017 AD.
 */
public class Player {

    private static String target = "";

    public static boolean isBattle = false;

    private static int[] fleePos = new int[2];

    private static int x = 2;
    private static int y = 0;
    private static int floor = 1;

    private static final Item[] itemBags = new Item[6];

    private static ArrayList<String> questBag;

    private static int HP = 100;



    private boolean isValidMovableInput(String dir) {
        String[] possibleDirection = {"north","east","west","south"};
        String lowerInput = dir.toLowerCase();
        return Arrays.asList(possibleDirection).contains(lowerInput);
    }

    private boolean isRoomValidMove(String dir){
        Room currentRoom = WorldMap.worldMap.get(floor)[x][y];
        return currentRoom.canGo(dir);
    }

    private int move(String dir){
        if(!isBattle){
            dir = dir.toLowerCase();
            if(isValidMovableInput(dir) && isRoomValidMove(dir)){
                fleePos[0] = this.x;
                fleePos[1] = this.y;
                switch (dir){
                    case "north":
                        this.y-=1;
                    case "east":
                        this.x+=1;
                    case "west":
                        this.x-=1;
                    case "south":
                        this.y+=1;
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

    public boolean isValidAttack(String target){
        Room currentRoom = WorldMap.worldMap.get(floor)[x][y];
        if(target.equals(currentRoom.getGuardian().getName())) {
            isBattle = true;
            this.target = target;
            return true;
        }
        return false;
    }

    public int attackWith(String choice){
        if(this.isBattle) {
            choice = choice.toLowerCase();
            String enemy = genComputer();
            return compareChoice(choice, enemy);
        }
        return -2;
    }

    public boolean canCollectItem(){
        for(int i = 0 ;i<6;i++){
            if (itemBags[i] == null){
                return true;
            }
        }
        return false;
    }

    public int isValidCollect(String item){
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
        return ""+this.HP;
    }



}
