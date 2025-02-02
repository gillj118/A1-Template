package ca.mcmaster.se2aa4.mazerunner;

public class MazeSettings {

    public int[] findOpenings(int rows, int cols, char maze [][])
    {
        int westOpeningX = 0;
        int westOpeningY = 0;
        int eastOpeningX = 0;
        int eastOpenngY = 0;        

        for (int i = 0; i<rows ; i++)
        {
            if (maze[i][0] == ' ')
            {
                westOpeningX = 0; 
                westOpeningY = i;
            }

            if (maze[i][cols-1] == ' ')
            {
                eastOpeningX = cols-1;
                eastOpenngY = i;
            }
        }
        int [] coords = {westOpeningX,westOpeningY,eastOpeningX,eastOpenngY};
        return coords;
    }   
}
