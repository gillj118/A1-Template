package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeReader {
    private String mazeFile;


   
    public MazeReader(String mazeFile) 
    {
        this.mazeFile = mazeFile;
    }

    public Maze readMaze() throws IOException
    {
        String [] info = getSize();
        int rows = Integer.parseInt(info[0]);
        int cols = Integer.parseInt(info[1]);
        String linearMaze = info[2];
        char [][] maze =  new char [rows][cols];

        for (int i = 0; i<rows; i ++)
        {
            for (int j = 0; j<cols; j++)
            {
                maze [i][j] = linearMaze.charAt((i*cols)+j);
            }
            
        }
        return new Maze(rows,cols,maze);
    }


    private String[] getSize() throws IOException
    {
        int cols = 0;
        int tempCols = 0;
        int rows=0;
        String linearMaze= "";
        try(BufferedReader reader = new BufferedReader(new FileReader(mazeFile)))
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                rows++;
                if (rows == 1)
                {
                    cols = line.length();
                }

                if (line.length() == 0)
                {
                    for(int i = 0; i<cols; i++)
                    {
                        linearMaze += " ";
                    }
                }

                else
                {
                    linearMaze += line;
                    tempCols = line.length();

                    if (cols > tempCols)
                    {
                        for (int i = 0; i< cols - tempCols; i++)
                        {
                            linearMaze += " ";
                        }
                    }

                }
            }
        
        }
        String [] info = {Integer.toString(rows),Integer.toString(cols),linearMaze};
        return info;
    }
}