package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class PaperCommand implements Command {
    private Player player;

    public PaperCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply() {
        int result = player.attackWith("paper");
        if(result == -2){
            System.out.println("You are not in the battle");
        }
        else if(result==1){
            System.out.println("You win. Your enemy health is "+player.getCurrentRoom().getGuardian().getHP());
        }
        else if(result==0){
            System.out.println("It's a Draw");
        }
        else {
            System.out.println("You lose. Your health is "+player.checkHP());
            if(player.isDead()){
                System.out.println("Sorry, you died");
                new ExitCommand().apply();
            }
        }
    }
}
