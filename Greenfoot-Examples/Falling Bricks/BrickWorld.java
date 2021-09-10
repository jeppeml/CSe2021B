import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BrickWorld extends World
{
    private int tickCount = 0;
    
    public BrickWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        spawnPlayer();
    }
    
    public void act(){
        tickCount = tickCount + 1;
        if(tickCount==50){
            spawnBrick();
            tickCount = 0;
        }
    }
    
    public void spawnBrick(){
        // Spawn brick at random location
        int randomX = Greenfoot.getRandomNumber(600);
        addObject(new Brick(), randomX, 40);
    }
    
        
    public void spawnPlayer(){
        // Spawn player 300, 360 
        addObject(new Dragon(), 300, 360);
    }
}
