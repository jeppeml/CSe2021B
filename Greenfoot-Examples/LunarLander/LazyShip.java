import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LazyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LazyShip extends Ship
{
    /**
     * Act - do whatever the LazyShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(90);
        move(velocity); 
        if(Greenfoot.isKeyDown("space")) {
            velocity -= thrust;
        }
        velocity += gravity;
    }    
}
