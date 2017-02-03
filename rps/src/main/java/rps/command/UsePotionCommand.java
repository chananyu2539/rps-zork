package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class UsePotionCommand implements Command {
    private Player player;

    public UsePotionCommand(){
        this.player = ZorkGame.getInstance();
    }


    @Override
    public void apply(String s) {
        if(s.equals("healingpotion")) {
            int status = player.useHealPotion();
            if (status == -2) {
                System.out.println("You don't have healing potion!");
            } else if (status == 0) {
                System.out.println("Your HP is already full.");
            } else {
                System.out.println("Successfully heal, your current HP is: " + player.checkHP());
            }
        }
        else if(s.equals("debuffpotion")){
            int status = player.useDebuffPotion();
            if(status == -2){
                System.out.println("You don't have debuff potion!");
            }
            else if(status==0){
                System.out.println("You can already debuff guardian");
            }
            else {
                System.out.println("Successfully used debuff, enemy cannot play 'rock'");
            }

        }
        else {
            System.out.println("Invalid input");
        }
    }


}
