package ca.mcmaster.se2aa4.mazerunner;

public class Maze{

	private char [][] maze;
	private int rows;
	private int cols;

	public Maze(int rows, int cols, char [][] maze)
	{
		this.cols = cols;
		this.rows = rows;
		this.maze = maze;
	}


	public void printMaze()
	{
		System.out.println("COMPASS");
		System.out.println("     ↑N");
		System.out.println("W ←      → E");
		System.out.println("     ↓S");


		for (int i = 0; i<rows ; i++)
		{
			for (int j = 0; j<cols;j++)
			{
				
				System.out.print(maze[i][j]);
				// if (maze[i][j] == ' ')
				// {
				// 	System.out.print(" ");
				// }

				// else if (maze[i][j] == '#')
				// {
				// 	System.out.print("#");
				// }

			}
			System.out.println();
		}
	}

	public void entry(String entry)
	{
		return;
	}

}