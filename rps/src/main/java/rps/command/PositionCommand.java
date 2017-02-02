package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class PositionCommand implements Command {
    private Player player;

    public PositionCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        int coordinate[] = player.checkPos();
        System.out.println("x: "+coordinate[1]+", y: "+coordinate[0]);
    }
}
