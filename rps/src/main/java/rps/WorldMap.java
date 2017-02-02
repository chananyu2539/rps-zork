package rps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chananyu2539 on 1/30/2017 AD.
 */
public class WorldMap {
    public static final Map<Integer,Room[][]> worldMap = new HashMap<Integer, Room[][]>();
    private static final Room[][] firstFloor = (new MapGenerator()).firstFloorGenerator();

    private static final Room[][] secondFloor = new Room[3][3];

    private static final Room[][] thirdFloor = new Room[2][1];

    {
        worldMap.put(1,firstFloor);
        worldMap.put(2,secondFloor);
        worldMap.put(3,thirdFloor);

    }




}
