package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements MazeCommand {
    private MazeWalk walker;

    public TurnRightCommand(MazeWalk walker) {
        this.walker = walker;
    }

    @Override
    public void execute() 
    {
        walker.turnRight();
    }

    @Override
    public void undo() 
    {
        //undo right turn with a left turn
        walker.turnLeft();
    }
}
