package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm implements MazeAlgorithmSolver{
    
    private char [][] maze;
    private int endXCoord;
    private int endYCoord;
    private MazeWalk walker;
    private WallChecker wallChecker;

    public RightHandAlgorithm(char [][] maze, int []coords, char facingDirection)
    {
        this.maze = maze;
        this.endXCoord = coords[2];
        this.endYCoord = coords[3];
        this.walker = new MazeWalk (coords[0],  coords[1], facingDirection);
        this.wallChecker = new WallChecker(walker, maze);
    }
   
    public String pathSearch()
    {
        String path ="";

        //goes until final coords are reached
        while (!((walker.getXCoord() == endXCoord) && (walker.getYCoord() == endYCoord))) 
        {
             //wall on right side
            if (wallChecker.checkRightHandWall() == true)
            {
                if (wallChecker.checkMoveForward() == true) 
                {
                    walker.moveForward();
                    path = path + "F";
                }

                else
                {
                    walker.turnLeft();
                    path = path + "L";
                }
            }
            //if there is no wall on right side
            else
            {
                walker.turnRight();
                path = path + "R";

                if(wallChecker.checkMoveForward() == true)
                {
                    walker.moveForward();
                    path = path + "F";
                }
            }

        }
        return path;
    }
}
