package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class AttackCommand implements Command {

    private Player player;

    public AttackCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        if(player.validAttack()){
            System.out.println("Engage in fight");
        }else {
            System.out.println("There is no guardian in this room.");
        }

    }


}
