import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    
    public Dragon(Size sizeOfDragon){
        super();
        if(sizeOfDragon == Size.SMALL){
            getImage().scale(15,15);
        }
        else if(sizeOfDragon == Size.MEDIUM){
            getImage().scale(50,50);
        }
        else if(sizeOfDragon == Size.LARGE){
            getImage().scale(100,100);
        }
    }
    
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








