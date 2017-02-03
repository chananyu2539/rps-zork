package rps;


import rps.command.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by chananyu2539 on 2/1/2017 AD.
 */
public class ZorkGame {
    private static Player player;

    final static HashMap<String, Command> commands = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("go", new MoveCommand());


            put("flee", new FleeCommand());

            put("attack", new AttackCommand());
            put("rock",new RockCommand());
            put("paper",new PaperCommand());
            put("scissors",new ScissorCommand());


            put("use", new UsePotionCommand());
            put("position",new PositionCommand());
            put("take", new PickItemCommand());
            put("drop",new DropItemCommand());
            put("checkbag",new CheckBagCommand());
            put("checkhp",new CheckHPCommand());
            put("info",new LookAroundCommand());
            put("quit", new ExitCommand());
            put("help", new HelpCommand());
            put("combine", new CombineKeyCommand());

//                put("useQuestItem", new UseItemCommand());


        }
    };

    public static Player getInstance() {
        if (null == player) {
            player = new Player();
        }
        return player;
    }



    public static Command getCommand(String name) {
        return commands.get(name);
    }

    public static void run(){


//        System.out.println(player.getCurrentRoom().getInfo());

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        System.out.println("Zork: Welcome to RPS-Zork game");
        System.out.println("Zork: You are currently at the first floor, please find your way out and defeat final boss at thrid floor :)");
                System.out.println(player.getCurrentRoom().getInfo());

        while (!quit) {
            System.out.print("You: ");
            String[] commandLine = scanner.nextLine().split("\\s+");
            Command command = null;
            try {
                command = ZorkGame.getCommand(commandLine[0]);
            }catch (ArrayIndexOutOfBoundsException ai){
            }
            if (null == command ) {
                System.out.println("Unknown command try 'help'.");
            } else {
//                System.out.println(commandLine.length);
                if (commandLine.length < 2){
                    command.apply("");
                }
                else {
                    command.apply(commandLine[1]);
                }
            }
        }



    }
}
