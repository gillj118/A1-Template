package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public class MazeWalk {
    private int xCoord;
    private int yCoord;
    private char direction;
    private List<MazeObserver> observers = new ArrayList<>();

    public MazeWalk(int startX, int startY, char direction) 
    {
        this.xCoord = startX;
        this.yCoord = startY;
        this.direction = direction;
    }

    public void addObserver(MazeObserver observer) 
    {
         observers.add(observer);
    }
    
    public void removeObserver(MazeObserver observer) 
    {
         observers.remove(observer);
    }
    
    private void notifyObservers(String event) 
    {
         for(MazeObserver obs : observers) {
             obs.update(event, this);
         }
    }
    
    public void turnRight() 
    {
        if (direction == 'N') 
        {
            direction = 'E';
        } 
        else if (direction == 'E')
        {
            direction = 'S';
        } 
        else if (direction == 'S') 
        {
            direction = 'W';
        } 
        else 
        {
            direction = 'N';
        }
        notifyObservers("Turned Right");
    }

    public void turnLeft() 
    {
        if (direction == 'N') 
        {
            direction = 'W';
        } 
        else if (direction == 'W') 
        {
            direction = 'S';
        } 
        else if (direction == 'S') 
        {
            direction = 'E';
        } 
        else 
        {
            direction = 'N';
        }
        notifyObservers("Turned Left");
    }

    public void moveForward() 
    {
        if (direction == 'N') 
        {
            yCoord -= 1;
        } 
        else if (direction == 'S') 
        {
            yCoord += 1;
        } 
        else if (direction == 'W') 
        {
            xCoord -= 1;
        } 
        else 
        {
            xCoord += 1;
        }
        notifyObservers("Moved Forward");
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public char getDirection() {
        return direction;
    }
}
