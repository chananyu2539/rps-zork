package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class FleeCommand implements Command {
    private Player player;

    public FleeCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        boolean fleeable = player.flee();
        if(fleeable){
            System.out.println("You flee to the older room, but your hp was reduced by 5");
            System.out.println("Your current hp is" + player.checkHP());
        }
        else {
            System.out.println("You are not in the battle");
        }
    }
}
