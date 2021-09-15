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
    double startingAngle = 90;// starting angle
    double countTicks=startingAngle; 
    boolean firstTime = true;
    double velocity = 1; // degrees per tick
    double yCompared;

    public Ant(double rx, double ry, double startingAngle){
        super();
        r = rx;
        yCompared = ry/rx;
        this.startingAngle = startingAngle;
        getImage().scale(20,20);
    }

    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstTime){
            firstTime = false;
            xStart = getX();// + r * Math.cos(countTicks);
            yStart = getY();// - 0.4 * r * Math.sin(countTicks);

        }
        double rads = Math.toRadians(countTicks);
        double x = xStart + r * Math.cos(rads);
        double y = yStart + yCompared * r * Math.sin(rads);
        countTicks+=velocity;

        // Compensate for xStart and yStart is center of ellipsis
        // Calculates correct start location for angle
        double startRads = Math.toRadians(startingAngle);
        setLocation(x - r * Math.cos(startRads), y- yCompared * r * Math.sin(startRads));
        
        getWorld().addObject(new Turd(30*4),getX(),getY());
    }    
}
