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

    public Room[][] secondFloorGenerator(){
        Room[][] result = new Room[3][3];

        Room room00 = new Room();
        room00.addObj(new Potion("rock"));
        room00.addObj(new Potion());


        Room room01 = new Room();
        room01.setGuardian(new Guardian("Curator A",40));

        Room room02 = new Room();
        room02.addObj(new Potion());
        room02.addObj(new QuestItem(2));

        Room room10 = new Room();
        room10.setGuardian(new Guardian("Curator B",40));
        Room room11 = new Room();
        room11.addObj(new Potion("rock"));

        Room room12 = new Room();
        room12.setGuardian(new Guardian("Curator C",40));

        Room room20 = new Room();
        room20.addObj(new Potion());

        Room room21 = new Room();
        room21.addObj(new Potion("rock"));
        room21.addObj(new QuestItem(1));
        room21.setGuardian(new Guardian("Curator D",40));

        Room room22 = new Room();

        room00.setExit("east",room01);
        room00.setExit("south",room10);

        room01.setExit("west",room00);
        room01.setExit("east",room02);
        room01.setExit("south",room11);

        room02.setExit("west",room01);
        room02.setExit("south",room12);

        room10.setExit("north",room00);
        room10.setExit("south",room20);
        room10.setExit("east",room11);

        room11.setExit("north",room01);
        room11.setExit("east",room12);
        room11.setExit("west",room10);
        room11.setExit("south",room21);

        room12.setExit("north",room02);
        room12.setExit("west",room11);
        room12.setExit("south",room22);

        room20.setExit("east",room21);
        room20.setExit("north",room10);

        room21.setExit("west",room20);
        room21.setExit("east",room22);
        room21.setExit("north",room11);

        room22.setExit("west",room21);
        room22.setExit("north",room12);

        result[0][0] = room00;
        result[0][1] = room01;
        result[0][2] = room02;

        result[1][0] = room10;
        result[1][1] = room11;
        result[1][2] = room12;

        result[2][0] = room20;
        result[2][1] = room21;
        result[2][2] = room22;




        return result;
    }

    public Room[][] thirdFloorGenerator() {
        Room[][] result = new Room[2][1];
        Room room10 = new Room();
        room10.addObj(new Potion());
        room10.addObj(new Potion("rock"));
        Room room00 = new Room();
        room00.setGuardian(new Guardian("Tower Boss",100));

        room10.setExit("north",room00);

        result[0][0] = room00;
        result[1][0] = room10;
        return result;

    }
}
