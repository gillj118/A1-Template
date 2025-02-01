package ca.mcmaster.se2aa4.mazerunner;


import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        
        logger.info("** Starting Maze Runner");
        
        Options options = new Options();
        options.addOption("i",true,"Input file containing maze");
        
        CommandLineParser parser = new DefaultParser();
        
        try {

            CommandLine cmd =  parser.parse(options, args);
            String mazeFile = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + mazeFile);

            MazeReader mazeRead = new MazeReader(mazeFile);
            Maze maze = mazeRead.readMaze();
            maze.printMaze();

             MazeSettings settings = new MazeSettings();
             
             int [] entranceExitCoords = settings.findStartEnd(maze.getRows(),maze.getCols(),maze.returnCopy());

             System.out.println("Starting coords: (x,y) " + entranceExitCoords[0] + " " + entranceExitCoords[1]);
             System.out.println("ENding coords: (x,y) " + entranceExitCoords[2] + " " + entranceExitCoords[3]);
            
             char facingDirection;
             char sideStart;

             //Westside start
             if (entranceExitCoords[0] == 0)
             {
               sideStart = 'W';
               facingDirection = 'E';
             }

             //Eastside start
             else
             {
                sideStart = 'E';
                facingDirection = 'W';
             }
            
            RightHandAlgorithm algorithm = new RightHandAlgorithm(maze.returnCopy(),entranceExitCoords,facingDirection);

            String path = algorithm.pathSearch();

            StringManipulator manip = new StringManipulator();

            System.out.println("Path: " + path);
            System.out.println("Factoried Path " + manip.toFactorized(path));

            

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

    }
}
