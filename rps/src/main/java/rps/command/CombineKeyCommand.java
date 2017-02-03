package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class CombineKeyCommand implements Command {
    private Player player;

    public CombineKeyCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply(String s) {
        int status = player.combineKey();
        if(status == 1){
            System.out.println("Creating portal..........");
            player.goThirdFloor();
            new LookAroundCommand().apply("");
        }
        else if(status==0){
            System.out.println("You have to defeat the Guardian first");
        }
        else {
            System.out.println("Don't have both keys to be combined");
        }
    }
}
