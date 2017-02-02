package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class MoveEastCommand implements Command{
    private Player player;

    public MoveEastCommand(){
        this.player = ZorkGame.getInstance();
    }
    @Override
    public void apply() {
        int status = player.move("east");
        if(status==0){
            System.out.println("Can't move. You are in the battle");
        }
        else if(status==-1){
            System.out.println("You can't move that way!");
        }
        else {
            System.out.println("Moving east..........");
            new LookAroundCommand().apply();
        }
    }
}
