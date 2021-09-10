import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Butterfly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Butterfly extends Actor
{
    
    
    private int life = 0;
    private ButterflyCounter counter;
    private boolean counterInit = false;
    
    
    public Butterfly(int life){
        super();
        this.life = life;
    }
    /**
     * Act - do whatever the Butterfly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!counterInit){
            MyWorld mw = (MyWorld)getWorld();
            counter = new ButterflyCounter(this, "Life: ");
            mw.addObject(counter, getX(), getY()-40);
            counterInit=true;
        }
        life = life -1;
        counter.setValue(life);
        move(6);
        turn(7);
        checkIfDie();
        
        // Add your action code here.
    }    
    
    private void checkIfDie(){
        if(life<=0){
            getWorld().removeObject(this);
        }
    }
}
