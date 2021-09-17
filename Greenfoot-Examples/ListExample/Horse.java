import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse extends Actor
{
    private int speed;
    
    public Horse(){ // Constructor
        speed = Greenfoot.getRandomNumber(8-4)+4;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void act() 
    {
        move(speed);
    }    
}
