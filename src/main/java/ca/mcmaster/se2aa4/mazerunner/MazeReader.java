package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeReader {
    private String mazeFile;

   
    public MazeReader(String mazeFile) {
        this.mazeFile = mazeFile;
    }

    
    public Maze readMaze() {
        
        return new Maze(0,0);
    }
}