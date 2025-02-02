package ca.mcmaster.se2aa4.mazerunner;

public class MazeSettings {

    // public int [] findStartEnd(int rows, int cols, char maze [][])
    // {
    //     int randNum = (int)(Math.random()*2);
    //     int []coords = findOpenings(rows,cols,maze);

    //     //Westside start
    //     if (randNum == 0)
    //     {
    //        return coords;
    //     }

    //     //Eastside start
    //     else
    //     {
    //         int westOpeningX = coords[0];
    //         int westOpeningY = coords[1];
    //         coords[0] = coords[2];
    //         coords[1] = coords[3];
    //         coords[2] = westOpeningX;
    //         coords[3] = westOpeningY;
    //         return coords;
    //     }

    // }


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
