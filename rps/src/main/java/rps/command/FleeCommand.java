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
    public void apply(String s) {
        boolean fleeable = player.flee();
        if(fleeable){
            System.out.println("You flee to the older room, but your hp was reduced by 5");
            System.out.println("Your current hp is " + player.checkHP());
            if(player.isDead()){
                System.out.println("Sorry, you died");
                new ExitCommand().apply("");
            }
        }
        else {
            System.out.println("You are not in the battle");
        }
    }
}
