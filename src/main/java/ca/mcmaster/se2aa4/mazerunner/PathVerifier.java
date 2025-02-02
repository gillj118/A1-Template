package ca.mcmaster.se2aa4.mazerunner;


public class PathVerifier{

//	private MazeWalk walker;
	private char [][] maze;
	private int []openingCoords;
	private String path;


	public PathVerifier(char [][] maze, int [] openingCoords,String path)
	{
		this.maze = maze;
		this.openingCoords = openingCoords;
		this.path = path.trim();
	}

	public boolean verifyPath()
	{
		MazeWalk walkerWest = new MazeWalk(openingCoords[0],openingCoords[1],'E');
		WallChecker wallCheckerWest = new WallChecker(walkerWest, maze);
		boolean westCorrectPath = pathChecker(walkerWest,wallCheckerWest,openingCoords[2],openingCoords[3]);
		
		MazeWalk walkerEast = new MazeWalk(openingCoords[2],openingCoords[3],'W');
		WallChecker wallCheckerEast = new WallChecker(walkerEast, maze);
		boolean eastCorrectPath = pathChecker(walkerEast,wallCheckerEast,openingCoords[0],openingCoords[1]);

		if ((westCorrectPath == true) || (eastCorrectPath == true))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean pathChecker(MazeWalk walker, WallChecker wallChecker, int endXCoord, int endYCoord)
	{
		int counter = 0;
		char direction;
		System.out.println("Expected End Coordinates: (" + endXCoord + ", " + endYCoord + ")");
    	System.out.println("Initial Position: (" + walker.getXCoord() + ", " + walker.getYCoord() + ")");
   		System.out.println("Path Received: " + path);

		while (!((walker.getXCoord() == endXCoord) && (walker.getYCoord() == endYCoord)) && (path.length()>counter))
		{
			
			direction = path.charAt(counter);
			System.out.println("Step " + counter + ": Moving " + direction);

			if (direction == 'F')
			{
				if (wallChecker.checkMoveForward() == false)
				{
					return false;
				}
				walker.moveForward();
			}
			else if(direction == 'R')
			{
				walker.turnRight();
			}
			else if(direction == 'L')
			{
				walker.turnLeft();
			}
			else
			{
				return false;
			}

			if ((counter < (path.length()-1)) &&  (wallChecker.checkMoveForward() == false) && (path.charAt(counter+1) == 'F'))
			{
				return false;
			}

			System.out.println("New Position: (" + walker.getXCoord() + ", " + walker.getYCoord() + ")");
			counter++;
		}

		System.out.println("End Position: (" + walker.getXCoord() + ", " + walker.getYCoord() + ")");
		System.out.println("Expected position: (" + endXCoord + ", " + endYCoord + ")");
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