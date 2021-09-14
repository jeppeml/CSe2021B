import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Actor
{
    double xStart = 300;
    double yStart = 200;
    double r = 270;
    double countTicks;
    boolean firstTime = true;
    
    
    /**
     * Act - do whatever the Ant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(firstTime){
            xStart = getX();
            yStart = getY();
            firstTime = false;
        }
        int x = (int)(xStart + r * Math.cos(countTicks));
        int y = (int)(yStart + 0.4 * r * Math.sin(countTicks));
        //getWorld().addObject(new Ant(), x,y);
        countTicks+=0.2;
        
        setLocation(x,y);
        // Add your action code here.
    }    
}
