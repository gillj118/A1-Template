package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements MazeCommand {
    private MazeWalk walker;

    public MoveForwardCommand(MazeWalk walker) {
        this.walker = walker;
    }

    @Override
    public void execute() 
    {
        walker.moveForward();
    }

    @Override
    public void undo() 
    {
        walker.turnRight();
        walker.turnRight();
        walker.moveForward();
        walker.turnRight();
        walker.turnRight();
    }
}
