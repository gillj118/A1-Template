package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm {
    
    private char [][] maze;
    private int endXCoord;
    private int endYCoord;
    private MazeWalk walker;
    private WallChecker wallChecker;

    public RightHandAlgorithm(char [][] maze, int []coords, char facingDirection)
    {
        System.out.println("Start: (" + coords[0] + ", " + coords[1] + ")");
        System.out.println("End: (" + coords[2] + ", " + coords[3] + ")");
        this.maze = maze;
        this.endXCoord = coords[2];
        this.endYCoord = coords[3];
        this.walker = new MazeWalk (coords[0],  coords[1], facingDirection);
        this.wallChecker = new WallChecker(walker, maze);
    }
   
    public String pathSearch()
    {
        String path ="";

        while (!((walker.getXCoord() == endXCoord) && (walker.getYCoord() == endYCoord))) 
        {
            // System.out.println("Hi");
            // System.out.println(path);
        //    System.out.println("X Coord, YCoord: " + walker.getXCoord() + ", " + walker.getYCoord());

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
