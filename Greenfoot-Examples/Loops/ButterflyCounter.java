import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButterflyCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButterflyCounter extends Counter
{
    private Butterfly butterfly;
    
    public ButterflyCounter(Butterfly butterfly, String prefix){
        super(prefix);
        this.butterfly = butterfly;
    }
    
    /**
     * Act - do whatever the ButterflyCounter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation((butterfly.getX());
        setY(butterfly.getY()-40);
        // Add your action code here.
    }    
}
