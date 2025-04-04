package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class RightHandAlgorithm implements MazeAlgorithmSolver {

    private char[][] maze;
    private int endXCoord;
    private int endYCoord;
    private MazeWalk walker;
    private WallChecker wallChecker;
    private MazeCommandInvoker invoker; 
    private MacroCommand macro;         
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
              obs.update(event, walker);
         }
    }

    public RightHandAlgorithm(char[][] maze, int[] coords, char facingDirection) 
    {
        this.maze = maze;
        this.endXCoord = coords[2];
        this.endYCoord = coords[3];
        this.walker = new MazeWalk(coords[0], coords[1], facingDirection);
        this.wallChecker = new WallChecker(walker, maze);
        this.invoker = new MazeCommandInvoker();
        this.macro = new MacroCommand();
    }

    @Override
    public String pathSearch() 
    {
        //goes until final coords are reached
        while (!(walker.getXCoord() == endXCoord && walker.getYCoord() == endYCoord)) 
        {
            //wall on right side
            if (wallChecker.checkRightHandWall()) 
            {
                if (wallChecker.checkMoveForward()) 
                {
                    MazeCommand moveFwd = new MoveForwardCommand(walker);
                    invoker.executeCommand(moveFwd);
                    macro.addCommand(moveFwd);
                    notifyObservers("Moved Forward via Right-Hand Rule");
                } 
                else 
                {
                    MazeCommand turnLeft = new TurnLeftCommand(walker);
                    invoker.executeCommand(turnLeft);
                    macro.addCommand(turnLeft);
                    notifyObservers("Turned Left via Right-Hand Rule");
                }
            } 
            //if there is no wall on right side
            else 
            {
                MazeCommand turnRight = new TurnRightCommand(walker);
                invoker.executeCommand(turnRight);
                macro.addCommand(turnRight);
                notifyObservers("Turned Right via Right-Hand Rule");
                
                if (wallChecker.checkMoveForward()) 
                {
                    MazeCommand moveFwd = new MoveForwardCommand(walker);
                    invoker.executeCommand(moveFwd);
                    macro.addCommand(moveFwd);
                    notifyObservers("Moved Forward after Turning Right");
                }
            }
        }
        notifyObservers("Reached Maze Exit");
        //return the canonical representation of path
        return macro.getCanonicalPath();
    }
}

