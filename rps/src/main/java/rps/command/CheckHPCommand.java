package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class CheckHPCommand implements Command {

    private Player player;

    public CheckHPCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        System.out.println(player.checkHP());
    }

}
