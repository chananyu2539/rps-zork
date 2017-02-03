package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class PotionTest {
    @Test
    public void getInfo() throws Exception {
        Potion p = new Potion();
        assertTrue(p.getInfo().equals("healing potion, can heal: 10, can silence: None"));
        Potion d = new Potion("rock");
        assertTrue(d.getInfo().equals("debuff potion, can heal: 0, can silence: rock"));

    }

    @Test
    public void getName() throws Exception {
        Potion p = new Potion();
        assertTrue(p.getName().equals("healing potion"));
        Potion d = new Potion("rock");
        assertTrue(d.getName().equals("debuff potion"));
    }

}