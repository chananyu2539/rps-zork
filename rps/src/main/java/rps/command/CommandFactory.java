//package rps.command;
//
///**
// * Created by chananyu2539 on 2/1/2017 AD.
// */
//import rps.Player;
//
//import java.util.HashMap;
//import java.util.Scanner;
//
//public final class CommandFactory {
//
//    private static final HashMap<String, Command> commands = new HashMap<String, Command>() {
//        {
//            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
//            put("move", new MoveCommand());
//            put("flee", new FleeCommand());
//            put("quit", new ExitCommand());
//            put("attack", new AttackCommand());
//            put("useItem", new UseItemCommand());
//            put("position",new PositionCommand());
//            put("pick", new PickCommand());
//            put("inspect", new InspectCommand());
//            put("checkBag",new CheckBagCommand());
//            put("checkHP",new CheckHPCommand());
//            put("lookAround",new LookAroundCommand());
//            put("useQuestItem", new UseItemCommand());
//
//
//        }
//    };
//
//    public static Command getCommand(String name) {
//        return commands.get(name);
//    }
//
//    public static void main(final String[] arguments) {
//        Scanner scanner = new Scanner(System.in);
//        boolean quit = false;
//        Player player = new Player();
//        System.out.println("Bot: Hello, command me!!");
//        while (!quit) {
//            System.out.print("You: ");
//            String commandLine = scanner.nextLine();
//            Command command = CommandFactory.getCommand(commandLine);
//            if (null == command) {
//                System.out.println("Unknown command [" + commandLine + "]. Available commands: Light on, Light off and quit.");
//            } else {
//                command.apply();
//            }
//        }
//
//    }
//
//}