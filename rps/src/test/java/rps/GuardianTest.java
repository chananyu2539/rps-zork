package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class GuardianTest {
    @Test
    public void getInfo() throws Exception {
        Guardian guardian = new Guardian("Guardian A",23);
        assertTrue(guardian.getInfo().equals("Guardian, Name: Guardian A, HP: 23"));
        Guardian guardianB = new Guardian("Guardian B",15);
        assertTrue(guardianB.getInfo().equals("Guardian, Name: Guardian B, HP: 15"));
    }

    @Test
    public void getName() throws Exception {
        Guardian guardian = new Guardian("Test Name",100);
        assertTrue(guardian.getName().equals("Test Name"));

        Guardian guardianB = new Guardian("Test R",10);
        assertTrue(guardianB.getName().equals("Test R"));
    }

    @Test
    public void isDead() throws Exception {
        Guardian guardian = new Guardian("Dead G",0);
        assertTrue(guardian.isDead());

        Guardian guardianB = new Guardian("Alive G",1);
        assertFalse(guardianB.isDead());


    }

}