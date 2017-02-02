package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class UseSilencePotionCommand implements Command {
    private Player player;

    public UseSilencePotionCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        int status = player.useSilencePotion();
        if(status == -2){
            System.out.println("You have no silence potion!");
        }
        else if(status==0){
            System.out.println("You can already debuff guardian");
        }
        else {
            System.out.println("Successfully used silence, enemy cannot play 'rock'");
        }

    }
}
