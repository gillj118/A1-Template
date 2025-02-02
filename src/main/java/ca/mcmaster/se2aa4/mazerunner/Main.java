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
        options.addOption("p",true,"Path checker");
        
        CommandLineParser parser = new DefaultParser();
        
        try {

            CommandLine cmd =  parser.parse(options, args);

            if (cmd.hasOption("i") == false)
            {
                logger.error("Remember to use -i before the file you want to use.");
                return;
            }

            String mazeFile = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + mazeFile);

            MazeReader mazeRead = new MazeReader(mazeFile);
            Maze maze = mazeRead.readMaze();
            maze.printMaze();

             MazeSettings settings = new MazeSettings();
             
             int [] entranceExitCoords = settings.findOpenings(maze.getRows(),maze.getCols(),maze.returnCopy());

             System.out.println("Starting coords: (x,y) " + entranceExitCoords[0] + " " + entranceExitCoords[1]);
             System.out.println("ENding coords: (x,y) " + entranceExitCoords[2] + " " + entranceExitCoords[3]);
            
             char facingDirection = 'E';
             char sideStart = 'W';
             
             if (cmd.hasOption("p"))
             {
                String path = cmd.getOptionValue("p");

                if (path == null || path.isEmpty()) 
                {
                    logger.error("Error: No path provided with -p flag.");
                    return;
                }
                System.out.println("Path received for verification: " + path);

                PathVerifier pathVerifier = new PathVerifier(maze.returnCopy(),entranceExitCoords,path);
                boolean correctPath = pathVerifier.verifyPath();
                if (correctPath == true)
                {
                    System.out.println("correct input");
                }
                else
                {
                    System.out.println("incorrect input");
                }

             }

             else
             {

                RightHandAlgorithm algorithm = new RightHandAlgorithm(maze.returnCopy(),entranceExitCoords,facingDirection);

                String path = algorithm.pathSearch();

                StringManipulator manip = new StringManipulator();

                System.out.println("Path: " + path);
                System.out.println("Factoried Path " + manip.toFactorized(path));
             }

            

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\",e);
        }

    }
}
