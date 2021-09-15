import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Curious here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Curious extends SmoothMover
{
    /**
     * Act - do whatever the Curious wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.getMouseInfo()!=null){
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        getWorld().addObject(new Turd(30*10),getX(),getY());
        move(4);
    }
    }    
}
