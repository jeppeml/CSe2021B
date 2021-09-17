import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse extends SmoothMover
{
    private double speed;
    
    public Horse(){ // Constructor
        speed = (Greenfoot.getRandomNumber(400)+400)/100d;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public void act() 
    {
        move(speed);
    }    
}
