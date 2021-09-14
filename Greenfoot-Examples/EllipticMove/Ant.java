import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends SmoothMover
{
    double xStart = 300;
    double yStart = 200;
    double r = 200; // Radius base
    double countTicks=45; // starting angle
    boolean firstTime = true;
    double velocity = 0.01; // degrees per tick
    
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstTime){
            firstTime = false;
            xStart = getX() - r * Math.cos(countTicks);
            yStart = getY() - 0.4 * r * Math.sin(countTicks);
        }
        double x = xStart + r * Math.cos(countTicks);
        double y = yStart + 0.4 * r * Math.sin(countTicks);
        //getWorld().addObject(new Ant(), x,y);
        countTicks+=0.01;
        
        setLocation(x,y);
        // Add your action code here.
    }    
}
