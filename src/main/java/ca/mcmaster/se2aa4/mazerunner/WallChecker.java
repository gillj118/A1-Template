package ca.mcmaster.se2aa4.mazerunner;


public class WallChecker{

	private char [][]maze;
	private MazeWalk walker;

	public WallChecker(MazeWalk walker, char [][] maze)
	{
		this.maze = maze;
		this.walker = walker;
	}

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


    public boolean checkMoveForward()
    {
        int xCoord = walker.getXCoord();
        int yCoord = walker.getYCoord();
        char direction = walker.getDirection();

        if (direction == 'N')
        {
            if (maze[yCoord-1][xCoord] == ' ')
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
            if (maze[yCoord+1][xCoord] == ' ')
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
            if (maze[yCoord][xCoord+1] == ' ')
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
            if (maze[yCoord][xCoord-1] == ' ')
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