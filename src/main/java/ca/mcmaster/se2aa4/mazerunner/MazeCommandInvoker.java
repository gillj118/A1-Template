package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MazeCommandInvoker {
    private Stack<MazeCommand> history = new Stack<>();
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

    public void executeCommand(MazeCommand command) 
    {
        command.execute();
        history.push(command);
        notifyObservers("Executed Command: " + command.getClass().getSimpleName());
    }

    public void undoLastCommand() 
    {   
        if (!history.isEmpty()) 
        {
            MazeCommand command = history.pop();
            command.undo();
            notifyObservers("Undone Command: " + command.getClass().getSimpleName());
        }
    }

    public void clearHistory() 
    {
        history.clear();
        notifyObservers("Cleared Command History");
    }
}
