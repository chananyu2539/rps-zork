package rps.command;

import rps.Player;
import rps.Room;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/1/2017 AD.
 */
public class LookAroundCommand implements Command {

    private Player player;

    public LookAroundCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply(String s) {
        Room room = player.getCurrentRoom();
        System.out.println(room.getInfo());
    }
}
