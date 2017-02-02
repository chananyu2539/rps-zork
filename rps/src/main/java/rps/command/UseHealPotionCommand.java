package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class UseHealPotionCommand implements Command {
    private Player player;

    public UseHealPotionCommand(){
        this.player = ZorkGame.getInstance();
    }


    @Override
    public void apply() {
        int status = player.useHealPotion();
        if(status == -2){
            System.out.println("You have no potion!");
        }
        else if(status==0){
            System.out.println("Your HP is already full.");
        }
        else {
            System.out.println("Successfully heal, your current HP is: "+player.checkHP());
        }
    }


}
