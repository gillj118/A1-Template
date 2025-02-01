package ca.mcmaster.se2aa4.mazerunner;


public class MazeWalk
{
	private int xCoord;
	private int yCoord;
	private char direction;

	public MazeWalk(int startX, int startY, char direction)
	{
		this.xCoord = startX;
		this.yCoord = startY;
		this.direction = direction;

	}

	public void turnRight()
	{
		if (direction == 'N')
		{
			this.direction = 'E';
		}

		else if (direction == 'E')
		{
			this.direction = 'S';
		}

		else if (direction == 'S')
		{
			this.direction = 'W';
		}

		else
		{
			this.direction = 'N';
		}

	}

	public void turnLeft()
	{
		if (direction == 'N')
		{
			this.direction = 'W';
		}

		else if (direction == 'W')
		{
			this.direction = 'S';
		}

		else if (direction == 'S')
		{
			this.direction = 'E';
		}

		else
		{
			this.direction = 'N';
		}

	}

	public void moveForward()
	{
		if (direction == 'N')
		{
			this.yCoord -= 1;
		}

		else if (direction == 'W')
		{
			this.xCoord -= 1;
		}

		else if (direction == 'S')
		{
			this.yCoord += 1;
		}

		else
		{
			this.xCoord +=1;
		}
	}

	public int getXCoord()
	{
		return this.xCoord;
	}

	public int getYCoord()
	{
		return this.yCoord;
	}

	public char getDirection()
	{
		return this.direction;
	}

}