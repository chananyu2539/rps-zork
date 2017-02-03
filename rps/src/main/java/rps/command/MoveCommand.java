package rps.command;

import rps.Player;
import rps.Room;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class MoveCommand implements Command {
    private Player player;

    public MoveCommand(){
        this.player = ZorkGame.getInstance();
    }
    @Override
    public void apply(String direction) {


        if(player.isBattle){
            System.out.println("Can't move. You are in the battle");
        }
        else {
            int status = player.move(direction);
            if (status == -1) {
                System.out.println("You can't move that way!");
            }
            else if(status==-2){
                System.out.println("You have to defeat the guardian first");
            }
            else {
                System.out.println("Moving " + direction + "..........");
                new LookAroundCommand().apply(direction);
            }
        }

    }
}
