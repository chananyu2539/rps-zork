package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 1/30/2017 AD.
 */
public class PlayerTest {
    @Test
    public void checkPos() throws Exception {
        Player player = new Player();
        int[] currentPos = player.checkPos();
        assertTrue(currentPos[0]==2 && currentPos[1]==0);
        player.setX(1);
        player.setY(3);
        currentPos = player.checkPos();
        assertTrue(currentPos[0]==1 && currentPos[1]==3);

    }

    @Test
    public void checkHP() throws Exception {
        Player player = new Player();
        assertTrue(player.checkHP().equals("100"));

    }


    @Test
    public void clearFinalBoss() throws Exception {
        Player player = new Player();
        assertFalse(player.clearFinalBoss());
    }

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