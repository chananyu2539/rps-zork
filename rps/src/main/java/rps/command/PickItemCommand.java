package rps.command;

import rps.Player;
import rps.ZorkGame;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class PickItemCommand implements Command {
    private Player player;

    public PickItemCommand(){
        this.player = ZorkGame.getInstance();
    }

    @Override
    public void apply(String s) {
        if(s.contains("key")){
            if(player.collect(s,-1) == 0){
                System.out.println("Successfully collect " + s +" to quest bag");
            }
            else {
                System.out.println("This room doesn't contain "+s);
            }
        }
        else {
            int emptySlot = player.itemEmptySlot();
            if (emptySlot > -1) {
                if (s.equals("healingpotion")) {
                    if (player.collect("healing potion", emptySlot) == 1) {
                        System.out.println("Healing potion successfully collected. It's stored in " + emptySlot + " slot");
                    } else {
                        System.out.println("This room doesn't have healing potion");
                    }
                } else if (s.equals("debuffpotion")) {
                    if (player.collect("debuff potion", emptySlot) == 1) {
                        System.out.println("Debuff potion successfully collected. It's stored in " + emptySlot + " slot");
                    } else {
                        System.out.println("This room doesn't have debuff potion");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            } else {
                System.out.println("Your item bag is full");
            }
        }
    }
}
