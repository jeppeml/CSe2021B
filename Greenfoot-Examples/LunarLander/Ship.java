import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends SmoothMover
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static double gravity=0.025;
     double velocity=1.0;
     double thrust=0.1;
     double maxLandVelocity=0.0;
     int earthYCoord = 500;
    public void act() 
    {
        setRotation(90);
        move(velocity); 
        if(Greenfoot.isKeyDown("space")) {
            velocity -= thrust;
        }
        velocity += gravity;
        //checkIfDie();
    }
    
    public void checkIfDie(){
        if(getY()>=earthYCoord || getY()<-150)
        {
            if(velocity>maxLandVelocity){
                MyWorld mw = (MyWorld)getWorld();
                mw.setText("You is DeD");
                mw.showFlames();
                getWorld().removeObject(this);
            }
            else{
                velocity=0;
                gravity=0;
            }
        }
    }
    }
