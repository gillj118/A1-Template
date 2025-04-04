package ca.mcmaster.se2aa4.mazerunner;

public interface MazeObserver {
    void update(String event, Object subject);
}