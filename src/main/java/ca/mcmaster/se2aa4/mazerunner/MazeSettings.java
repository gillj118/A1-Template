package ca.mcmaster.se2aa4.mazerunner;

public class MazeSettings {


    public int[] findOpeneings(int rows, int cols, char maze [][])
    {
        
        int westOpeningX = 0;
        int westOpeningY = 0;
        int eastOpeningX = 0;
        int eastOpenngY = 0;        

        for (int i = 0; i<rows ; i++)
        {
            if (maze[rows][0] == ' ')
            {
                westOpeningX = 0; 
                westOpeningY = rows;
            }

            if (maze[rows][cols-1] == ' ')
            {
                eastOpeningX = cols-1;
                eastOpenngY = rows;
            }
        }
        int [] coords = {westOpeningX,westOpeningY,eastOpeningX,eastOpenngY};
        return coords;
    }   


    public char findStart()
    {
        int randNum = (int)(Math.random());
        char start;

        if (randNum == 0)
        {
            start = 'W';
        }

        else
        {
            start = 'E';
        }
        return start;
    }
}
