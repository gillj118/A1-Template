package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class PathVerifier {

    private char[][] maze;
    private int[] openingCoords;
    private String path;
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
              obs.update(event, null);
         }
    }

    public PathVerifier(char[][] maze, int[] openingCoords, String path) {
        this.maze = maze;
        this.openingCoords = openingCoords;
        this.path = path.trim().toUpperCase();
    }

    public boolean verifyPath() 
    {
        //turns to cannonical is factorized
        StringManipulator manip = new StringManipulator();
        if (manip.checkFacotrized(path) == true)
        {
            this.path = manip.factorizedToCanonical(path);
        }
        MazeWalk walkerWest = new MazeWalk(openingCoords[0], openingCoords[1], 'E');
        MazeWalk walkerEast = new MazeWalk(openingCoords[2], openingCoords[3], 'W');
        
        //checks if path correxponds to starting at west side or east side
        boolean correct = pathChecker(walkerWest, openingCoords[2], openingCoords[3]) || pathChecker(walkerEast, openingCoords[0], openingCoords[1]);
        notifyObservers("Path verification result: " + correct);
        return correct;
    }

    private boolean pathChecker(MazeWalk walker, int endXCoord, int endYCoord) 
    {
        WallChecker wallChecker = new WallChecker(walker, maze);
        //replay the path with a macro command
        MacroCommand macro = new MacroCommand();
        for (int i = 0; i < path.length(); i++) 
        {
            char c = path.charAt(i);
            MazeCommand command;
            if (c == 'F') 
            {
                if (!wallChecker.checkMoveForward()) 
                {
                    return false;
                }
                command = new MoveForwardCommand(walker);
            } 
            else if (c == 'R') 
            {
                command = new TurnRightCommand(walker);
            } 
            else if (c == 'L') 
            {
                command = new TurnLeftCommand(walker);
            } 
            else 
            {
                return false;
            }
            command.execute();
            macro.addCommand(command);

            //if moving forward and wall infront
            if (i < path.length() - 1 && !wallChecker.checkMoveForward() && path.charAt(i + 1) == 'F') 
            {
                return false;
            }
        }
        //verify walker ended at the correct coordinates
        if ((walker.getXCoord() == endXCoord) && (walker.getYCoord() == endYCoord))
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}
