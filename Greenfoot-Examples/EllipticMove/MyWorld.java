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
        
        
        
    }
    
    /*
     * theta = 0;  // angle that will be increased each loop
        h = 12      // x coordinate of circle center
        k = 10      // y coordinate of circle center
        step = 15;  // amount to add to theta each time (degrees)
        
        repeat until theta >= 360;
            { x = h + r*cos(theta)
              y = k + r*sin(theta)
              draw a line to x,y
              add step to theta
            }
     */
}
