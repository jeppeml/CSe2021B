import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        double minTrackHeight = 100;
        double minTrackWidth = 180;
        double trackDistance = 20;
        double startingAngle = 90; // 0=east, 90 south etc.
        int trackStartX = 300;
        int trackStartY = 300;
        
        for(int i= 0;i<5;i++)
        {
            addObject(new Ant(minTrackWidth+i*trackDistance, minTrackHeight+i*trackDistance, 90), trackStartX, (int)(trackStartY+i*trackDistance));
        }
        addObject(new Curious(),300,200);
    }
}
