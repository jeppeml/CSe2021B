import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    private double gravity;
    private double wallIntervalSecs = 5;
    private int wallFrameCount = 0;
    private double hardness = 0.1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
        
        gravity=2.0;
        
        Wombat wombat = new Wombat();
        addObject(wombat, 200,300);
        
    }
    
    public void act(){
        spawnWalls();
    }
    
    private void spawnWalls(){
        if(wallFrameCount>30*wallIntervalSecs)
        {
            spawnWall();
            wallFrameCount=0;
            wallIntervalSecs -= hardness;
            if(wallIntervalSecs<0.5)
                wallIntervalSecs = 0.5;
        }
        wallFrameCount++;
    }
    private void spawnWall(){
        BrickWall bw = new BrickWall();
        GreenfootImage bwImg = bw.getImage();
        int width = bwImg.getWidth();
        int height = bwImg.getHeight();
        
        int scaledHeight =(int)( ((double)height)*
            ((double)(Greenfoot.getRandomNumber(300)+30))/100f);
        bwImg.scale(width, scaledHeight);
        
        addObject(bw, getWidth(), Greenfoot.getRandomNumber(getHeight()));
    }
    
    public double getGravity(){
        return gravity;
    }
    
    public void setGameOver(){
    
        Label lbl = new Label("Game Over", 30);
        addObject(lbl, getWidth()/2, 2*getHeight()/3);
        Greenfoot.stop();
    }
  
}
