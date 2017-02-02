package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 1/30/2017 AD.
 */
public class PlayerTest {
    @Test
    public void compareChoice() throws Exception {
        Player player= new Player();
        assertTrue(player.compareChoice("ROCK".toLowerCase(),"rock")==0);
    }

    @Test
    public void attack() throws Exception {
        Player player = new Player();
        assertTrue(player.attackWith("ROck")==-2);
        assertFalse(player.attackWith("ROck")!=-2);

    }


}