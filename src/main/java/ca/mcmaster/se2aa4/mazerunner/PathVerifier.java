package ca.mcmaster.se2aa4.mazerunner;


public class PathVerifier{

	private char [][] maze;
	private int []openingCoords;
	private String path;

	public PathVerifier(char [][] maze, int [] openingCoords,String path)
	{
		this.maze = maze;
		this.openingCoords = openingCoords;
		this.path = path.trim().toUpperCase();
	}

	public boolean verifyPath()
	{
		//turns to cannonical is factorized
		StringManipulator manip = new StringManipulator();
		if (manip.checkFacotrized(path) == true)
		{
			this.path = manip.factorizedToCanonical(path);
		}

		//checks if path correxponds to starting at west side
		MazeWalk walkerWest = new MazeWalk(openingCoords[0],openingCoords[1],'E');
		WallChecker wallCheckerWest = new WallChecker(walkerWest, maze);
		boolean westCorrectPath = pathChecker(walkerWest,wallCheckerWest,openingCoords[2],openingCoords[3]);
		
		//checks if path correxponds to starting at east side
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

		//walks though wall until wall is bumbed into or reach end
		while (!((walker.getXCoord() == endXCoord) && (walker.getYCoord() == endYCoord)) && (path.length()>counter))
		{	
			direction = path.charAt(counter);

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
			//if moving forward and wall infront
			if ((counter < (path.length()-1)) &&  (wallChecker.checkMoveForward() == false) && (path.charAt(counter+1) == 'F'))
			{
				return false;
			}
			counter++;
		}

		//check end coords
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