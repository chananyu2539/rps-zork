package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class CheckBagCommand implements Command {

    private Player player;

    public CheckBagCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply(String s) {
        System.out.println("Your item bag contain: ");
        System.out.println(player.checkBag());
    }
}
