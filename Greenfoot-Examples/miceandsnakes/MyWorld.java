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
        for(int i=0;i<5000;i++){
            Mouse m = new Mouse();
            addObject(m, 
                Greenfoot.getRandomNumber(getWidth()), 
                Greenfoot.getRandomNumber(getHeight()));
        
        }
        
        
        Snake s = new Snake();
        addObject(s, 300, 200);
    }
}
