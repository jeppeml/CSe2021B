import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButterflyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButterflyCounter extends Counter
{
    private Actor butterfly;
    
    public ButterflyCounter(Actor butterfly, String prefix){
        super(prefix);
        this.butterfly = butterfly;
    }
    
    /**
     * Act - do whatever the ButterflyCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(butterfly.getWorld()==null)
            getWorld().removeObject(this);
        else setLocation(butterfly.getX(),butterfly.getY()-40);
       
        // Add your action code here.
    }    
}
