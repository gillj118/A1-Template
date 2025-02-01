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
             
             int [] entranceExitCoords = settings.findStartEnd(maze.getRows(),maze.getCols(),maze.getMaze());

             System.out.println("Starting coords: (x,y) " + entranceExitCoords[0] + " " + entranceExitCoords[1]);
             System.out.println("ENding coords: (x,y) " + entranceExitCoords[2] + " " + entranceExitCoords[3]);
            // char facingDirection;



          //s   MazeWalk mazeWalk = new MazeWalk
            // if (sideStart == 'E')
            // {
            //     startCoords[0] =  openingCoords[2];
            //     startCoords[1] = openingCoords[3];

            //     finishCoords[0] = openingCoords[0];
            //     finishCoords[1] = openingCoords[1];

            //     facingDirection = 'W'; 
            //     System.out.println(facingDirection);

            //     mazeWalk = new MazeWalk(startCoords[0],startCoords[1], facingDirection);
            // }

            // else
            // {
            //     startCoords[0] =  openingCoords[0];
            //     startCoords[1] = openingCoords[1];

            //     finishCoords[0] = openingCoords[2];
            //     finishCoords[1] = openingCoords[3];

            //     facingDirection = 'E';

            //     mazeWalk = new MazeWalk(startCoords[0],startCoords[1],facingDirection);
            // }



            // RightHandAlgorithm solver = new RightHandAlgorithm();
            // if (solver.pathSearch(maze,mazeWalk, finishCoords[0],finishCoords[1], mazeFile) == true)
            // {
            //     logger.info("**** Computing path");
            //     logger.info("PATH COMPUTED");
            //     maze.printMaze();
            //     logger.info("** End of MazeRunner");
            //   }

            // else
            // {
            //     System.out.println("Maze solver has failed");
            // }

            

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

    }
}
