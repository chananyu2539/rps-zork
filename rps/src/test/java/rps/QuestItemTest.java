package rps;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class QuestItemTest {
    @Test
    public void getName() throws Exception {
        QuestItem questItem = new QuestItem(2);
        assertTrue(questItem.getName().equals("key2"));

        QuestItem questItem1 = new QuestItem(1);
        assertTrue(questItem1.getName().equals("key1"));

    }

    @Test
    public void getInfo() throws Exception {
        QuestItem questItem = new QuestItem(2);
        assertTrue(questItem.getInfo().equals("key: 2"));
        QuestItem questItem1 = new QuestItem(1);
        assertTrue(questItem1.getInfo().equals("key: 1"));
    }

}