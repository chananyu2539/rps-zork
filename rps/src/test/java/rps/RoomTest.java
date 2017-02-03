package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class RoomTest {
    @Test
    public void setGuardian() throws Exception {
        Room room = new Room();
        Guardian guardian = new Guardian("test",20);
        room.setGuardian(guardian);
        assertTrue(room.getGuardian() == guardian);
    }

    @Test
    public void setExit() throws Exception {
        Room room = new Room();
        room.setExit("north",new Room());
        room.setExit("east",new Room());

        assertTrue(room.canGo("north"));
        assertTrue(room.canGo("east"));
        assertFalse(room.canGo("west"));
        assertFalse(room.canGo("south"));
    }

    @Test
    public void canProceed() throws Exception {
        Room room = new Room();
        assertTrue(room.canProceed());
        Guardian guardian = new Guardian("test",20);
        room.setGuardian(guardian);
        assertFalse(room.canProceed());
        room.setGuardian(null);
        assertTrue(room.canProceed());
    }

    @Test
    public void getInfo() throws Exception {
        Room room = new Room();
        Guardian guardian = new Guardian("test",20);
        room.setGuardian(guardian);
        room.addObj(new Potion());
        room.addObj(new Potion("rock"));
        assertTrue(room.getInfo().equals("This room contains: \n" +
                "healing potion, can heal: 10, can silence: None\n" +
                "debuff potion, can heal: 0, can silence: rock\n" +
                "\n" +
                "======================================= \n" +
                "\n" +
                "Has guardian: Guardian, Name: test, HP: 20\n" +
                "\n" +
                "======================================= \n" +
                "\n" +
                "You can go the other room in following direction(s): \n"));
    }

}