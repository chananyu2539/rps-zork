package rps;

import rps.command.Command;
import rps.command.LookAroundCommand;

import java.util.HashMap;

/**
 * Created by chananyu2539 on 2/1/2017 AD.
 */
public class ZorkGame {
    public static void main(String[] args){
        final Player player = new Player();

        System.out.println(player.getCurrentRoom().getInfo());

//        final HashMap<String, Command> commands = new HashMap<String, Command>() {
//            {
//                // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
//                put("move", new MoveCommand(player));
//                put("flee", new FleeCommand());
//                put("quit", new ExitCommand());
//                put("attack", new AttackCommand());
//                put("useItem", new UseItemCommand());
//                put("position",new PositionCommand());
//                put("pick", new PickCommand());
//                put("inspect", new InspectCommand());
//                put("checkBag",new CheckBagCommand());
//                put("checkHP",new CheckHPCommand());
//                put("lookAround",new LookAroundCommand(player));
//                put("useQuestItem", new UseItemCommand());
//
//
//            }
//        };



    }
}
