import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    private double gravity = 0.4;
    private double velocityY = 0; // init 
    private double velocityX = 4; // fixed speed
    private int tickCount=1;
    private int jumpDuration = 10;
    private int countJump = jumpDuration;
    private boolean canJump=true;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tickCount++;
        doGravity();
        moveKeyboard();
        jump();
        // Add your action code here.
    }  
    
    private void jump(){
        if(Greenfoot.isKeyDown("up") && countJump>=jumpDuration){
           countJump = 0;
        }
        
        if(countJump<jumpDuration) // accelerate over <jumpDuration> ticks
        {
            countJump++;
            velocityY-=1.3;
        }
    }
    
    private void moveKeyboard(){
        if(Greenfoot.isKeyDown("left")){
            move(-(int)velocityX);
        }
        if(Greenfoot.isKeyDown("right")){
            move((int)velocityX);
        }
    }
    
    private boolean isTouchingFloor(){
        Floor floor = (Floor)getOneIntersectingObject(Floor.class);
        int worldBottom = (getWorld().getHeight()-(this.getImage().getHeight()/2));
        if(floor!=null || getY()>worldBottom){
            return true; 
        }
            
        return false;
    }
    
    
    private void doGravity(){
        velocityY += gravity;
        setLocation(getX(),(int)(getY()+velocityY));
        if(isTouchingFloor())
            velocityY = 0;
        
    }
}
