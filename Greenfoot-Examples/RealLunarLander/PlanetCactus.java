import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetCactus extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public PlanetCactus()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        createCactusPlanetSurface();
        createSpaceRocket();
    }
    
    
    private void createSpaceRocket(){
        Rocket r = new Rocket();
        int rocketY = (int)(this.getHeight()*0.1); // 10% from top
        addObject(r,this.getWidth()/2, rocketY);
        r.turn(-90);
    }
    
    private void createCactusPlanetSurface(){
        Cactus c = new Cactus();
        int cactusWidth = c.getImage().getWidth()/2;
        for(int i=0;i<getWidth()/cactusWidth;i++)
        {
            addObject(new Cactus(),cactusWidth/2+cactusWidth*i,this.getHeight());
        }
    }
}
