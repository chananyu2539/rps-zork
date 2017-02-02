package rps;

/**
 * Created by chananyu2539 on 1/31/2017 AD.
 */
public class MapGenerator {



    public Room[][] firstFloorGenerator(){
        Room[][] result = new Room[3][4];


        Room room20 = new Room();

        Room room10 = new Room();
        room10.setGuardian(new Guardian("Novice Guardian A",20));
        room10.addObj(new Potion());

        Room room11 = new Room();
        room11.setGuardian(new Guardian("Novice Guardian B",20));
        room11.addObj(new Potion("rock"));

        Room room01 = new Room();


        Room room12 = new Room();
        room12.addObj(new Potion());

        Room room13 = new Room();
        room13.setGuardian(new Guardian("Apprentice Guardian A",40));


        Room room03 = new Room();
        room03.setGuardian(new Guardian("Apprentice Guardian B",40));
        room03.addObj(new Potion("rock"));


        Room room23 = new Room();
        room23.setGuardian(new Guardian("Floor captain",50));

        room20.setExit("north",room10);

        room10.setExit("south",room20);
        room10.setExit("east",room11);

        room11.setExit("west",room10);
        room11.setExit("north",room01);
        room11.setExit("east",room12);

        room12.setExit("west",room11);
        room12.setExit("east",room13);

        room13.setExit("north",room03);
        room13.setExit("west",room12);
        room13.setExit("south",room23);

        room01.setExit("south",room11);

        room03.setExit("south",room13);

        room23.setExit("north",room13);

        result[0][1] = room01;
        result[0][3] = room03;
        result[1][0] = room10;
        result[1][1] = room11;
        result[1][2] = room12;
        result[1][3] = room13;
        result[2][0] = room20;
        result[2][3] = room23;

        return result;

    }

}
