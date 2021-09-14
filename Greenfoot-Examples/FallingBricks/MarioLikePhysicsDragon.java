import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class SimplerDragonCopy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarioLikePhysicsDragon extends SmoothMover
{
    //velocityX of the dragon when moving left/right
    private double velocityX = 0;

    // Velocity in Y direction
    private double velocityY=0;

    // Gravity applied in y direction
    private double gravity = 0.4;

    // Force opposing gravity in y direction for jumping
    private double jumpForce = -0.6;

    // Amount of acceleration in X direction
    private double accelX = 0.3;

    // Maximum velocityX in x direction
    private double maxVelocityX = 5;

    // Life the dragon as at its disposal  
    private int health = 3;

    // Check the status of the dragon whether it is in the air or not
    private boolean isInTheAir = false;

    // Length of time the MarioLikePhysicsDragon is allowed to jump
    private int jumpTime = 0;

    //Highest Y coordinate that is considered as the floor of the World used
    private int floorLevel = 380;
    
    // Waiting time in ticks between bubbles
    private int bubbleWait = 15;
    
    private int bubbleCount = 0;

    //image of the dragon used according to its movements
    private GreenfootImage imgDragonLeft = new GreenfootImage("Dragon.png");
    private GreenfootImage imgDragonRight = new GreenfootImage("Dragon-right.png");

    public MarioLikePhysicsDragon(){
        super();
        setImage(imgDragonRight);
    }
    
    public void act()
    {
        checkTouchGround();

        //check the keys pressed
        checkKeyPress();
        
        // Cap X velo
        capVelocityAndMove();

        //check if the SimplerDragonCopy is on a platform and if it is,
        //manage its Y coordinate and its isInTheAir attribute
        checkPlatform();

        //apply a constant value on Y coordinate increase
        applyGravity();

        // Move in y direction using physics from velocityY
        calculateAndMoveY();

        //check if the SimplerDragonCopy enter in collision with a Brick
        checkCollision();
    }

    private void calculateAndMoveY(){
        this.setLocation(this.getX(), this.getY() + velocityY);
    }

    //check the keys pressed by the player, and perform actions according to it.
    private void checkKeyPress() {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")){
            if(Greenfoot.isKeyDown("right")){
                this.setImage(imgDragonRight);
                velocityX += accelX;
            }
            if(Greenfoot.isKeyDown("left")){
                this.setImage(imgDragonLeft); 
                velocityX -= accelX;
            }
        }
        else velocityX = 0;

        if(Greenfoot.isKeyDown("up") ) {
            jump();
        }
        
        if(Greenfoot.isKeyDown("space")){
            spawnBubbles();
        }
    }
    
    private void capVelocityAndMove(){
        if(velocityX>maxVelocityX)
            velocityX=maxVelocityX;

        if(velocityX < maxVelocityX * -1)
            velocityX = maxVelocityX * -1;
            
        move(velocityX);
    }
    
    private void spawnBubbles(){
        bubbleCount++;
        double bubbleSpeed = 15;
        int offsetX = getImage().getWidth();
        if(getImage()==imgDragonLeft){
            bubbleSpeed*=-1;
            offsetX*=-1;
        }
        
        if(bubbleCount % bubbleWait == 0) // Using modulo % for skipping bubbleWait amount of ticks
            getWorld().addObject(new PhysicsBubble(bubbleSpeed,50), getX()+offsetX, getY());
    }

    //method that check if the SimplerDragonCopy is touching a brick
    public void checkCollision () {
        BrickWorld bw = (BrickWorld)getWorld();
        bw.setHealth(health);
        Actor brick = getOneIntersectingObject(Brick.class);
        if(brick != null) {
            takeDmg(1);
            bw.setHealth(health);
            if(health==0)
            {
                getWorld().removeObject(this);
                Greenfoot.stop();
            }
            else
                getWorld().removeObject(brick);
        }
    }

    //method that apply gravity all the time and using jump to oppose gravity
    private void applyGravity() {
        //if the SimplerDragonCopy is not on the ground
        if(isInTheAir) {
            if(jumpTime >0) {
                velocityY += jumpForce*0.15*jumpTime;
                jumpTime -= 1;
            } else {
                if(this.getY()<=floorLevel){
                    this.setLocation(this.getX(),this.getY() + gravity);
                }
            }
        } 
        velocityY += gravity;

    }

    private void jump() {
        if(isInTheAir == false) {
            isInTheAir = true;
            jumpTime = 15;
        }
    }
    //method which reduce the health of the dragon by an amount provided in argument 
    private void takeDmg (int dmg) {
        health = health - dmg;
        if(health<=0)
        {
            health = 0;
        }
        
    }
    //method which check if the SimplerDragonCopy is touching the top of a platform
    public void checkPlatform() {
        int halfDragonHeightPx = getImage().getHeight()/2;
        Platform touchingPlatform = (Platform)getOneObjectAtOffset(0, halfDragonHeightPx, Platform.class); // doing (Platform) is called a "type cast" forcing the class to be of this type.

        if(touchingPlatform!=null && this.getY() <= touchingPlatform.getY() - halfDragonHeightPx ) {
            int halfPlatformWidthPx = touchingPlatform.getImage().getWidth()/2;
            int halfPlatformHeightPx = touchingPlatform.getImage().getHeight()/2;

            if(this.getX() + getImage().getWidth()/2 >= touchingPlatform.getX() - halfPlatformWidthPx && this.getX() <= touchingPlatform.getX() + halfPlatformWidthPx) {
                //if the amount of time allowed in the air is up.               
                if(jumpTime<=0) 
                    isInTheAir= false;

                setLocation(getX(), touchingPlatform.getY() - halfPlatformHeightPx - halfDragonHeightPx);
                velocityY=0;
            }
        } else {
            isInTheAir = true;
        }

    }

    //method which reset 
    private void checkTouchGround() {
        if(isTouchingGround()){
            this.setLocation(this.getX(),floorLevel); // set ground level
            velocityY=0;
            isInTheAir = false;
        }
    }

    private boolean isTouchingGround(){
        return this.getY() > floorLevel;
    }

}

