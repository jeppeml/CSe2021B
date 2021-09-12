import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    //speed of the dragon
    private int speed = 5;
    //gravidty indice applied to the dragon
    private int gravity = 8;
    //life the dragon as at its disposal  
    private int health = 150;
    //check the status of the dragon whether it is in the air or not
    private boolean inTheAir = false;
    //Lenght of time the Dragon is allowed to jump
    private int jumpTime = 0;
    //Highest Y coordinate that is considered as the floor of the World used
    private int floorLevel = 380;
    //image of the dragon used according to its movements
    private GreenfootImage img1 = new GreenfootImage("Dragon.png");
    private GreenfootImage img2 = new GreenfootImage("Dragon-right.png");
    
    
    public void act()
    {
       touchGround();
       
       //check the keys pressed
       checkKeyPress();
       //check if the Dragon is on a platform and if it is,
       //manage its Y coordinate and its inTheAir attribute
       checkPlatform();
       //apply a constant value on Y coordinate increase
       applyGravity();
       //check if the Dragon enter in collision with a Brick
       checkCollision();
    }
    //check the keys pressed by the player, and perform actions according to it.
    private void checkKeyPress() {
        if(Greenfoot.isKeyDown("left")){
            this.setImage(img1); ;
            move(speed*-1); 
        }
        if(Greenfoot.isKeyDown("right")){
            this.setImage(img2); 
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("space") ) {
            jump();
        }
    }
    //method that check if the Dragon is touching a brick
    public void checkCollision () {
        Actor brick = getOneIntersectingObject(Brick.class);
        if(brick != null) {
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    
    
    //method that apply gravity to the Dragon when it is not on top of a  
    //platform
    private void applyGravity() {
            //if the Dragon is not on the ground
            if(inTheAir ==true) {
                //if the Dragon allowed time in the Air without 
                //gravity obstruction is not finished we decrease its Y
                //cordinate value making it look like it is jumping
                if(jumpTime >0) {
                    this.setLocation(this.getX(),this.getY() + gravity -15);
                    jumpTime -= 1;
                //if the time is up, we apply gravity on the Dragon by  
                //increasing its Y coordinate    
                } else {
                    if(this.getY() <=floorLevel){
                        this.setLocation(this.getX(),this.getY() + gravity);
                    }
                }
            } 
            
    }
    //method that makes the dragon jump by setting the jumpTime variable
    //to a fixed amount(or jump height) and setting the variable inTheAir to true
    //the applyGravity method will then use these variable to set the 
    //vertical behavior of the Dragon
    private void jump() {
        //if the Dragon is already in the air,
        //it can't jump
        if(inTheAir ==false) {
            //We set the  values to true for inTheAir in order to signal 
            //to applyGravity() that the Dragon much now be
            //subjected to its rule, and the value of 
            //jumptime to 15 make the dragon jump for an amount of 15
            //execution of applyGravity() 
            inTheAir = true;
            jumpTime = 15;
        }
        
    }
    //method which reduce the health of the dragon by an amount provided in argument 
    private void takeDmg (int dmg) {
        health = health - dmg;
    }
    //method which check if the Dragon is touching the top of a platform
    public void checkPlatform() {
        //return a list of all the platform currently is the Dragon's vicinity
        List<Platform> platforms = getObjectsAtOffset(0,getImage().getHeight()/2,Platform.class);
        //if the dragon is touching a platform and the Dragon's Y
        //coordinate is higher than the platform found
        if(!platforms.isEmpty() && this.getY() <= platforms.get(0).getY() - getImage().getHeight()/2 ) {
            //We check if the Dragon X coordinate are comprised between the 
            //minimum and maximum X platform's coordinate, effectively confirming that
            //the dragon is standing on the platform
            //we then perform the necessary modifications on the Dragon's
            //Y coordinate in order to make it stand on it
            
            if(this.getX() + getImage().getHeight()/2 >= platforms.get(0).getX() - platforms.get(0).getImage().getWidth()/2 && this.getX() <= platforms.get(0).getX() + platforms.get(0).getImage().getWidth()/2) {
               //if the amount of time allowed in the air is up.               
               if(jumpTime<=0) 
                   inTheAir= false;
               //we set the Y location of the Dragon to the corresponding
               //Y of the platform it is currently on
               //this method is called at the same time as the 
               //applyGravity one, making them negate each other 
               //while the Dragon is standing on the platform
               //once the Dragon exit the platform, the applyGravity method
               //will exercise its right again
               setLocation(getX(), platforms.get(0).getY() - platforms.get(0).getImage().getHeight()/2 - getImage().getHeight()/2);
              
               
               }
            //if the amount on time spent in the air is not up, that means that
            //the dragon is still currently in its ascession phase, in order to not
            //hinder its movements, we set the InTheAir to true for it to naturally
            //finish its current course
            
            } else {
                inTheAir = true;
            }
       
       
    }
    
    //method which reset 
    public void touchGround() {
        if(this.getY()  > floorLevel){
            this.setLocation(this.getX(),floorLevel);
            inTheAir = false;
            //return true;
        }
      //return false;
    }
         
   
         
    
    
}


    

