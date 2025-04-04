package ca.mcmaster.se2aa4.mazerunner;

import java.util.Stack;

public class MazeCommandInvoker {
    private Stack<MazeCommand> history = new Stack<>();

    public void executeCommand(MazeCommand command) 
    {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() 
    {
        if (!history.isEmpty()) {
            MazeCommand command = history.pop();
            command.undo();
        }
    }

    public void clearHistory() 
    {
        history.clear();
    }
}
