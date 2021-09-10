import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Actor
{
    int speed;
    int acceleration;
    
    public Brick(){
        super();
        getImage().scale(20,20);
        speed = 1;
        acceleration = 1;
        turn(90);
    }
    
    public void act() 
    {
        speed = speed + acceleration;
        move(speed);
        checkIfOutside();
    }  
    
    private void checkIfOutside(){
        if(getY()>398){
            getWorld().removeObject(this);
        }
    }
}
