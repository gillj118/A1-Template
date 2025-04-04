package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements MazeCommand 
{
    private List<MazeCommand> commands = new ArrayList<>();
    private List<MazeObserver> observers = new ArrayList<>();

    public void addObserver(MazeObserver observer) 
    {
         observers.add(observer);
    }
    
    public void removeObserver(MazeObserver observer)
    {
         observers.remove(observer);
    }
    
    private void notifyObservers(String event) 
    {
         for(MazeObserver obs : observers) 
         {
             obs.update(event, this);
         }
    }

    public void addCommand(MazeCommand command) 
    {
        commands.add(command);
        notifyObservers("Added Command: " + command.getClass().getSimpleName());
    }

    @Override
    public void execute() 
    {
        for (MazeCommand command : commands) 
        {
            command.execute();
        }
        notifyObservers("Executed MacroCommand");
    }

    @Override
    public void undo() 
    {
        for (int i = commands.size() - 1; i >= 0; i--) 
        {
            commands.get(i).undo();
        }
        notifyObservers("Undone MacroCommand");
    }

    public String getCanonicalPath() 
    {
        StringBuilder sb = new StringBuilder();
        for (MazeCommand command : commands) 
        {
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

