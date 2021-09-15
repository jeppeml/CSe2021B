import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turd extends SmoothMover
{
    private int acts = 0;
    private int livingTics;
    public Turd(int livingTics){
        getImage().scale(4,4);
        this.livingTics = livingTics;
    }
    /**
     * Act - do whatever the Turd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        acts++;
        if(acts>livingTics)
            getWorld().removeObject(this);
    }    
}
