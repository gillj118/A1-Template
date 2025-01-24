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


        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        //logger.info("**** Computing path");
       // logger.info("PATH NOT COMPUTED");
        //logger.info("** End of MazeRunner");
    }
}
