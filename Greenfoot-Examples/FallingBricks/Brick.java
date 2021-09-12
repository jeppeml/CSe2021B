import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Actor
{
    private int speed;
    private int acceleration = 0;
    public Brick() {
        super();//to be sure that the actor constructor is taken into account and 
        //it's properties kept, without it, the risk is that tha actor constructor 
        //will be overwritten
        //getImage().scale(20,20);
        speed = 3;
        //acceleration =1;
        turn(90);
    }
    public void act()
    {
        speed = speed + acceleration;
        //turn(90);
        move(speed);
        checkIfOutside();
    }
    private void checkIfOutside() {
        if(getY() >398) {
            getWorld().removeObject(this);
        } 
    }
}
