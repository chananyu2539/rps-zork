package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class DropItemCommand implements Command {
    private Player player;

    public DropItemCommand(){
        this.player = ZorkGame.getInstance();
    }


    @Override
    public void apply(String s){
        if(s.equals("")){
            System.out.println("Can't drop nothing");
        }
        else {
            try {
                if(player.dropItem(Integer.parseInt(s)))
                    System.out.println("Successfully drop "+s+"'s slot item");
                else {
                    System.out.println("There is no item in "+s+"'s slot.");
                }
            }
            catch (Exception e){
                System.out.println("Invalid item to be dropped");
            }
        }

    }
}
