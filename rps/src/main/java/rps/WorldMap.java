package rps;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by chananyu2539 on 1/30/2017 AD.
 */
public class WorldMap {
    public final Map<Integer,Room[][]> worldMap = new HashMap<Integer, Room[][]>();
    private final Room[][] firstFloor = (new MapGenerator()).firstFloorGenerator();

    private final Room[][] secondFloor = (new MapGenerator()).secondFloorGenerator();

    private final Room[][] thirdFloor = (new MapGenerator()).thirdFloorGenerator();


    {
        worldMap.put(1,firstFloor);
        worldMap.put(2,secondFloor);
        worldMap.put(3,thirdFloor);

    }

    public Room getFirstBossRoom(){
        return worldMap.get(1)[2][3];
    }

    public Room getLastBossRoom(){
        return worldMap.get(3)[0][0];
    }





}
