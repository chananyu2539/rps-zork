package rps;


import org.junit.Test;
import rps.command.*;


import static org.junit.Assert.*;

/**
 * Created by chananyu2539 on 2/3/2017 AD.
 */
public class ZorkGameTest {

    ZorkGame zorkGame = new ZorkGame();

    @Test
    public void getExitCommand(){
        String[] args = new String[1];
        args[0] = "quit";
        assertTrue(zorkGame.getCommand(args[0]) instanceof ExitCommand);
    }

    @Test
    public void getWalkCommand() throws Exception {
        String[] args = new String[2];
        args[0] = "go";
        assertTrue(zorkGame.getCommand(args[0]) instanceof MoveCommand);
    }
    @Test
    public void getInfoCommand() throws Exception {
        String[] args = new String[2];
        args[0] = "info";
        assertTrue(zorkGame.getCommand(args[0]) instanceof LookAroundCommand);
    }

    @Test
    public void getHelpCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "help";
        assertTrue(zorkGame.getCommand(args[0]) instanceof HelpCommand);
    }

    @Test
    public void getTakeCommand() throws Exception {
        String[] args = new String[2];
        args[0] = "take";
        assertTrue(zorkGame.getCommand(args[0]) instanceof PickItemCommand);
    }

    @Test
    public void getDropCommand() throws Exception {
        String[] args = new String[2];
        args[0] = "drop";
        assertTrue(zorkGame.getCommand(args[0]) instanceof DropItemCommand);
    }

    @Test
    public void getUseCommand() throws Exception {
        String[] args = new String[2];
        args[0] = "use";
        assertTrue(zorkGame.getCommand(args[0]) instanceof UsePotionCommand);
    }

    @Test
    public void getFightCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "attack";
        assertTrue(zorkGame.getCommand(args[0]) instanceof AttackCommand);
    }

    @Test
    public void getRockCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "rock";
        assertTrue(zorkGame.getCommand(args[0]) instanceof RockCommand);
    }
    @Test
    public void getPaperCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "paper";
        assertTrue(zorkGame.getCommand(args[0]) instanceof PaperCommand);
    }

    @Test
    public void getScissors() throws Exception {
        String[] args = new String[1];
        args[0] = "scissors";
        assertTrue(zorkGame.getCommand(args[0]) instanceof ScissorCommand);
    }

    @Test
    public void getCombineKeyCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "combine";
        assertTrue(zorkGame.getCommand(args[0]) instanceof CombineKeyCommand);
    }

    @Test
    public void getFleeCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "flee";
        assertTrue(zorkGame.getCommand(args[0]) instanceof FleeCommand);
    }

    @Test
    public void getCheckBagCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "checkbag";
        assertTrue(zorkGame.getCommand(args[0]) instanceof CheckBagCommand);
    }


    @Test
    public void getCheckHPCommand() throws Exception {
        String[] args = new String[1];
        args[0] = "checkhp";
        assertTrue(zorkGame.getCommand(args[0]) instanceof CheckHPCommand);
    }


}