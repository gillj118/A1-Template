package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm {
    private MazeWalk mazeWalk;
    private int endXCoord;
    private int endYCoord;


    public RightHandAlgorithm(char [][] maze, int []coords, char facindDirection)
    {
        this.mazeWalk = new MazeWalk (coords[0],  coords[1], facindDirection);
        this.endXCoord = coords[2];
        this.endYCoord = coords[3];
    }

   
    public boolean pathSearch ()
    {
        return false;
    }
}
