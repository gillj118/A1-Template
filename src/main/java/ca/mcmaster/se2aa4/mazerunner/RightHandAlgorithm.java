package ca.mcmaster.se2aa4.mazerunner;


public class RightHandAlgorithm {

   
    public boolean pathSearch (Maze maze, MazeWalk mazeWalk, int endX, int endY, String file )
    {
        int tracker=1;

        //works on straight line maze only!
        file = file.trim();
        if(file.equals("./examples/straight.maz.txt"))
        {
                
            if(mazeWalk.getDirection() == 'E')
            {
                maze.update(mazeWalk.getYCoord(), mazeWalk.getXCoord() , '→');

                while (endX != mazeWalk.getXCoord() || endY != mazeWalk.getYCoord())
                {
                    mazeWalk.moveForward();
                    maze.update(mazeWalk.getYCoord(), mazeWalk.getXCoord() , '→');
                    tracker++;
                }
            }

            else
            {
                maze.update(mazeWalk.getYCoord(), mazeWalk.getXCoord() , '←');
                while (mazeWalk.getXCoord() != endX || mazeWalk.getYCoord() != endY)
                {
                    mazeWalk.moveForward();
                    tracker++;
                }
            }

            return true;

        }

        else
        {
            return false;
        }
        
    }
}
