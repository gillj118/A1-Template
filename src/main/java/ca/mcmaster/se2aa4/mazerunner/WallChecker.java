package ca.mcmaster.se2aa4.mazerunner;


public class WallChecker{

	private char [][]maze;
	private MazeWalk walker;

	public WallChecker(MazeWalk walker, char [][] maze)
	{
		this.maze = maze;
		this.walker = walker;
	}

	//checks if there is a wall on the right hand based on coordinates
    public boolean checkRightHandWall()
    {
        int xCoord = walker.getXCoord();
        int yCoord = walker.getYCoord();
        char direction = walker.getDirection();

        if (direction == 'N')
        {
            if (maze[yCoord][xCoord+1] == '#')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else if (direction == 'S')
        {
            if (maze[yCoord][xCoord-1] == '#')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else if (direction == 'E')
        {
            if (maze[yCoord+1][xCoord] == '#')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else
        {
            if (maze[yCoord-1][xCoord] == '#')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

    }

    //check if there is a wall infront before moving forward
    public boolean checkMoveForward()
    {
        int xCoord = walker.getXCoord();
        int yCoord = walker.getYCoord();
        char direction = walker.getDirection();

        if (direction == 'N' && yCoord > 0 )
        {
            if (maze[yCoord-1][xCoord] == ' ' ) 
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else if (direction == 'S' && yCoord < maze.length - 1)
        {
            if (maze[yCoord+1][xCoord] == ' ')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

        else if (direction == 'E' && xCoord < maze[0].length - 1)
        {
            if (maze[yCoord][xCoord+1] == ' ')
            {
                return true;
            }

            else
            {
                return false;
            }
        }
        else if (direction == 'W' && xCoord > 0)
        {
            if (maze[yCoord][xCoord-1] == ' ')
            {
                return true;
            }
            
            else
            {
                return false;
            }
        }
        return false;
    }
}