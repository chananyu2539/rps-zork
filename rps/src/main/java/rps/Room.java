package rps;


import java.util.*;

/**
 * Created by chananyu2539 on 1/12/2017 AD.
 */
public class Room {
    private final static int MAX_ITEMS = 3;
    private final Item[] itemList = new Item[MAX_ITEMS];
    private final Map<String,Room> neighbors = new HashMap<>();
    private Guardian guardian = null;


    public boolean canGo(String dir){
        return neighbors.containsKey(dir);
    }

    public void setGuardian(Guardian guardian){
        this.guardian = guardian;

    }
    public Guardian getGuardian(){
        return this.guardian;
    }
    public Item[] getItemList(){
        return this.itemList;
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
        if(this.guardian != null) {
            rs += "\n======================================= \n";
            rs += "\nHas guardian: " + getGuardian().getInfo()+"\n";
        }
        rs+="\n======================================= \n";
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

    public boolean canProceed(){
        return this.guardian == null;
    }

}
