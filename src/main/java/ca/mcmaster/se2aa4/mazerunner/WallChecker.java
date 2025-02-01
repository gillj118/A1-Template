package ca.mcmaster.se2aa4.mazerunner;


public class WallChecker{

	private char [][]maze;
	private MazeWalk walker;

	public WallChecker(MazeWalk walker, char [][] maze)
	{
		this.maze = maze;
		this.walker = walker;
	}

	private boolean checkRightHandWall()
    {
        int xCoord = walker.getXCoord();
        int yCoord = walker.getYCoord();
        char direction = walker.getDirection();

        if (direction == 'N')
        {
            if (maze[xCoord+1][yCoord] == '#')
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
            if (maze[xCoord-1][yCoord] == '#')
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
            if (maze[xCoord][yCoord+1] == '#')
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
            if (maze[xCoord][yCoord-1] == '#')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

    }


    private boolean checkMoveForward()
    {
        int xCoord = walker.getXCoord();
        int yCoord = walker.getYCoord();
        char direction = walker.getDirection();

        if (direction == 'N')
        {
            if (maze[xCoord][yCoord-1] == ' ')
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
            if (maze[xCoord][yCoord+1] == ' ')
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
            if (maze[xCoord+1][yCoord] == ' ')
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
            if (maze[xCoord-1][yCoord] == ' ')
            {
                return true;
            }

            else
            {
                return false;
            }
        }

    }




}