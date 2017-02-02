package rps.command;

import rps.Player;
import rps.Room;

/**
 * Created by chananyu2539 on 2/1/2017 AD.
 */
public class LookAroundCommand implements Command {

    private Player player;

    public LookAroundCommand(Player p){
        this.player = p;
    }

    @Override
    public void apply() {
        Room room = player.getCurrentRoom();
        System.out.println(room.getInfo());
    }
}
