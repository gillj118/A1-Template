package ca.mcmaster.se2aa4.mazerunner;

public class TurnLeftCommand implements MazeCommand {
    private MazeWalk walker;

    public TurnLeftCommand(MazeWalk walker) {
        this.walker = walker;
    }

    @Override
    public void execute() 
    {
        walker.turnLeft();
    }

    @Override
    public void undo() 
    {
        //undo left turn with a right turn
        walker.turnRight();
    }
}
