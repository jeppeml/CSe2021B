import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    int speed = 8;
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollision();
        checkKeyPress();
    }    
    
    private void checkKeyPress(){
        if(Greenfoot.isKeyDown("left")){
            setRotation(180);
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("right")){
            setRotation(0);
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("up")){
            setRotation(270);
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("down")){
            setRotation(90);
            move(speed);
        }
    }
    
    public void checkCollision(){
        Actor brick = getOneIntersectingObject(Brick.class);
        if(brick!=null){
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    
}








