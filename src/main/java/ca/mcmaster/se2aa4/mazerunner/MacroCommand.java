package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements MazeCommand {
    private List<MazeCommand> commands = new ArrayList<>();

    public void addCommand(MazeCommand command) 
    {
        commands.add(command);
    }

    @Override
    public void execute() 
    {
        for (MazeCommand command : commands) 
        {
            command.execute();
        }
    }

    @Override
    public void undo() 
    {
        //undo in reverse order
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    public String getCanonicalPath() {
        StringBuilder sb = new StringBuilder();
        for (MazeCommand command : commands) {
            if (command instanceof MoveForwardCommand) 
            {
                sb.append("F");
            } 
            else if (command instanceof TurnRightCommand) 
            {
                sb.append("R");
            } 
            else if (command instanceof TurnLeftCommand) 
            {
                sb.append("L");
            }
        }
        return sb.toString();
    }
}
