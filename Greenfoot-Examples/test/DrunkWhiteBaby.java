import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DrunkWhiteBaby here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrunkWhiteBaby extends WhiteBaby
{
    /**
     * Act - do whatever the DrunkWhiteBaby wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        setRotation(Greenfoot.getRandomNumber(360)); // 0-359
    }    
}
