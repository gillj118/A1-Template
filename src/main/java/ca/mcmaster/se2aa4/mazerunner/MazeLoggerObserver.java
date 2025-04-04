package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeLoggerObserver implements MazeObserver {
     //logger
    private static final Logger logger = LogManager.getLogger();
    @Override
    public void update(String event, Object subject) 
    {
        logger.info("Observer: " + event);
    }
}