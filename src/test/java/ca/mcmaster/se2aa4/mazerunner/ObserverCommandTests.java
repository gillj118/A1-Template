package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObserverCommandTests {

    MazeWalk mazeWalk;

    @BeforeEach
    public void initialize() 
    {
        mazeWalk = new MazeWalk(0, 0, 'S');
    }

    @Test
    public void testTurnLeftCommand() 
    {
        TurnLeftCommand turnLeft = new TurnLeftCommand(mazeWalk);
        turnLeft.execute();

        assertEquals('E', mazeWalk.getDirection());
        turnLeft.undo();

        assertEquals('S', mazeWalk.getDirection());
    }

    @Test
    public void testTurnRightCommand() 
    {
        TurnRightCommand turnRight = new TurnRightCommand(mazeWalk);
        turnRight.execute();

        assertEquals('W', mazeWalk.getDirection());
        turnRight.undo();

        assertEquals('S', mazeWalk.getDirection());
    }

    @Test
    public void testMacroCommandCanonicalPath() 
    {
        MacroCommand macro = new MacroCommand();

        TurnLeftCommand leftCmd = new TurnLeftCommand(mazeWalk);
        TurnRightCommand rightCmd = new TurnRightCommand(mazeWalk);
        macro.addCommand(leftCmd);
        macro.addCommand(rightCmd);

        assertEquals("LR", macro.getCanonicalPath());
    }

    @Test
    public void testMacroCommandExecutionAndUndo() 
    {
        MacroCommand macro = new MacroCommand();
        TurnLeftCommand leftCmd = new TurnLeftCommand(mazeWalk);
        TurnRightCommand rightCmd = new TurnRightCommand(mazeWalk);
        macro.addCommand(leftCmd);
        macro.addCommand(rightCmd);

        macro.execute();
        assertEquals('S', mazeWalk.getDirection());

        macro.undo();
        assertEquals('S', mazeWalk.getDirection());
    }

    @Test
    public void testMazeCommandInvoker() 
    {
        MazeCommandInvoker invoker = new MazeCommandInvoker();

        TurnLeftCommand turnLeft = new TurnLeftCommand(mazeWalk);
        invoker.executeCommand(turnLeft);

        assertEquals('E', mazeWalk.getDirection());

        invoker.undoLastCommand();
        assertEquals('S', mazeWalk.getDirection());

        invoker.clearHistory();
    }

    @Test
    public void testRightHandAlgorithm() {
        char[][] maze = { { ' ' } };

        int[] coords = { 0, 0, 0, 0 };
        RightHandAlgorithm solver = new RightHandAlgorithm(maze, coords, 'S');

        String path = solver.pathSearch();
        assertEquals("", path);
    }
}
