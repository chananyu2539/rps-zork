package rps;


import rps.command.*;

import java.util.HashMap;

/**
 * Created by chananyu2539 on 2/1/2017 AD.
 */
public class ZorkGame {
    private static Player player;

    public static Player getInstance() {
        if (null == player) {
            player = new Player();
        }
        return player;
    }

    public static void main(String[] args){

//        System.out.println(player.getCurrentRoom().getInfo());

        final HashMap<String, Command> commands = new HashMap<String, Command>() {
            {
                // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
                put("go north", new MoveNorthCommand());
                put("go east", new MoveEastCommand());
                put("go west", new MoveWestCommand());
                put("go south", new MoveSouthCommand());

//                put("flee", new FleeCommand());

                put("attack", new AttackCommand());
                put("rock",new RockCommand());
                put("paper",new PaperCommand());
                put("scissor",new ScissorCommand());


                put("heal", new UseHealPotionCommand());
                put("silence", new UseSilencePotionCommand());
                put("position",new PositionCommand());
//                put("pick", new PickCommand());
//                put("inspect", new InspectCommand());
                put("checkBag",new CheckBagCommand());
                put("checkHP",new CheckHPCommand());
                put("lookAround",new LookAroundCommand());
                put("quit", new ExitCommand());

//                put("useQuestItem", new UseItemCommand());


            }
        };



    }
}
