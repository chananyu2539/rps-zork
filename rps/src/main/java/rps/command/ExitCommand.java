package rps.command;

/**
 * Created by chananyu2539 on 2/2/2017 AD.
 */
public class ExitCommand implements Command {
    @Override
    public void apply(String s) {
        System.out.println("Quitting game");
        System.exit(0);
    }
}
