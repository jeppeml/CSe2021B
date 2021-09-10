import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table extends Actor
{
    public int speed = 1;
    public boolean hungry = false;
    
    public Table(){
    
    }
    /**
     * Act - do whatever the Table wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(this.getX()>getWorld().getWidth())
            this.setLocation(0, getY());
        move(1);
        //move(speed);
       
    }    
    
    public void eat(){
        //food=food+1;
    }
}
