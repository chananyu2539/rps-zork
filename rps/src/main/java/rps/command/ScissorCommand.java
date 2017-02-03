package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class ScissorCommand implements Command {
    private Player player;

    public ScissorCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply(String s) {
        int result = player.attackWith("scissors");
        if(result == -2){
            System.out.println("You are not in the battle");
        }
        else if(result==1){
            System.out.println("You win. Your enemy health is "+player.getCurrentRoom().getGuardian().getHP());
        }
        else if(result==0){
            System.out.println("It's a Draw");
        }else if(result==4){
            System.out.println("You win. Your enemy is now dead.");
        }
        else {
            System.out.println("You lose. Your health is "+player.checkHP());
            if(player.isDead()){
                System.out.println("Sorry, you died");
                new ExitCommand().apply("");
            }
        }
        if(player.getFloor()==1 && player.canGoSecondFloor()){
            player.goSecondFloor();
            System.out.println("Congratulation, the final boss of first floor is dead.");
            System.out.println("You are now proceeding to the second floor");
            new LookAroundCommand().apply("");
        }
        else if(player.getFloor()==3 && player.clearFinalBoss()){
            System.out.println("You've done it. Congratulation on your escapes");
            new ExitCommand().apply("");
        }
    }
}
