package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm {
    private MazeWalk walker;
    private int endXCoord;
    private int endYCoord;
    private char [][] maze;


    public RightHandAlgorithm(char [][] maze, int []coords, char facindDirection)
    {
        this.maze = maze;
        this.walker = new MazeWalk (coords[0],  coords[1], facindDirection);
        this.endXCoord = coords[2];
        this.endYCoord = coords[3];
    }

   
    public boolean pathSearch()
    {

    //    while !( (walker.getXCoord() == endXCoord) && (walker.getYCoord() = endYCoord) )
      //  {

        //}
        return false;
    }



}
