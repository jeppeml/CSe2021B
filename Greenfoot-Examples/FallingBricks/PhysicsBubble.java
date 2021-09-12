import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PhysicsBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhysicsBubble extends SmoothMover
{
    private double velocityX;
    private double velocityY;
    private double bubbleLength = 1;
    private double maxBubbleLength;
    private double gravity = -0.1;
    private Actor holdingObject;

    public PhysicsBubble(double velocityX, double maxBubbleLength){
        this.velocityX = velocityX;
        this.maxBubbleLength = maxBubbleLength;
        getImage().scale(30,30);
    }

    private void pop(){
        if(holdingObject!=null)
            getWorld().removeObject(holdingObject);
        getWorld().removeObject(this);
    }

    private void moveBubble(){
        if(bubbleLength<maxBubbleLength)
        {
            bubbleLength += Math.abs(velocityX);
            setLocation(getX()+velocityX, getY());
        }         
        else
            setLocation(getX(), getY()+velocityY);
    }

    private void checkIfConsumeBrick(){
        Brick b = (Brick) getOneIntersectingObject(Brick.class);

        if(b!=null && holdingObject==null) // Can only hold one brick
            holdingObject = b;
        else if(b!=null && b==holdingObject){
            b.setLocation(getX(), getY());
        }
    }

    private void checkIfTouchDragon(){
        Actor dragon = getOneIntersectingObject(MarioLikePhysicsDragon.class);
        if(dragon!=null)
            pop();
    }

    public void act()
    {
        if(getY()<=0){ // top of screen
            pop();
        }
        else{ // else keep going
            velocityY += gravity;

            moveBubble();

            checkIfConsumeBrick();      
            
            checkIfTouchDragon();
        }
    }

}
