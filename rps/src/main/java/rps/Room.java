package rps;


import java.util.*;

/**
 * Created by chananyu2539 on 1/12/2017 AD.
 */
public class Room {
    private final static int MAX_ITEMS = 3;
    private Item[] itemList = new Item[MAX_ITEMS];
    private Map<String,Room> neighbors = new HashMap<String,Room>();
    private Guardian guardian = null;

    public boolean canGo(String dir){
        return neighbors.containsKey(dir);
    }

    public boolean containGuardian(String inName){
        return inName.equals(guardian.getName());
    }

    public void setGuardian(Guardian guardian){
        this.guardian = guardian;

    }
    public Guardian getGuardian(){
        return this.guardian;
    }
    public Item[] getItemList(){
        return this.getItemList();
    }



    public boolean addObj(Item item) {
        for(int i = 0; i < MAX_ITEMS;i++){
            if(itemList[i] == null){
                itemList[i] = item;
                return true;
            }
        }
        return false;

    }
    public String getInfo(){
        String rs = "";
        rs += "This room contains: \n";
        for(Item obj : itemList){
            if(obj!=null)
                rs += obj.getInfo() +"\n";
        }
        rs+="\n============================= \n";
        rs += "\nYou can go the other room in following direction(s): \n";
        for (String s: neighbors.keySet()){
            rs+=s+" \n";
        }
        return rs;
    }


    public void setExit(String dir,Room exitingRoom){
        switch (dir) {
            case "north":
            case "east":
            case "west":
            case "south":
                neighbors.put(dir,exitingRoom);

        }

    }

}
