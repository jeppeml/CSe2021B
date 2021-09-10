import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends SmoothMover
{
    private double velocityY=0;
    private double gravity=0.05;
    private double thrust=0.1;
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        velocityY+=gravity;
        
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("space"))
            velocityY-=thrust;
            
        this.setLocation(getX(),getY()+velocityY);
        
        if(getOneIntersectingObject(Cactus.class)!=null)
            Greenfoot.stop();
    }    
}
