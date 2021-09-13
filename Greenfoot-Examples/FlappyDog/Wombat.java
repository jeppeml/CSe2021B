import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends SmoothMover
{
    private double upForce=0;
    private double power=0.1;
    private boolean debounce = false;
    /**
     * Act - do whatever the Wombat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        detectKeypress();
        calculateMovement();
        checkCollision();
    }    
    
    private void checkCollision(){
        FlappyWorld fw = (FlappyWorld)getWorld();
        Actor brick = getOneIntersectingObject(BrickWall.class);
        if(brick!=null){
            fw.setGameOver();
        }
    }

    private void calculateMovement(){
        double gravity = ((FlappyWorld)getWorld()).getGravity();
        double dy = upForce - gravity;
        if(dy>2)
            setRotation(45);
        else if (dy<-2)
            setRotation(-45);
        else
            setRotation(0);
            
        this.setLocation(this.getX(), (int)(this.getY()-dy));
    }

    private void detectKeypress(){
        if(Greenfoot.isKeyDown("space"))
        {
            if(!debounce){
                upForce += 5.5;
                debounce=true;
            }
        }
        else
        {
            
            debounce=false;
        } 
        upForce -= power;
    }
}
