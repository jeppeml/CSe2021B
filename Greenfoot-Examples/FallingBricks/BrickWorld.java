import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BrickWorld extends World
{
    //USed to check how many frames has past
    private int tickCount = 0;
    private Counter counter = new Counter("❤");
    public BrickWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        spawnPlayer();
        addObject(new Platform(), 288, 337);
        addObject(new Platform(), 162, 249);
        addObject(new Platform(), 281, 165);
        addObject(new Platform(), 412, 249);
        addObject(counter,550,counter.getImage().getHeight()/2+5);
        
        setPaintOrder( Brick.class,PhysicsBubble.class); // making bubble be under Brick
    }
    
    public void setHealth(int health){
        counter.setValue(health);
    }
    
    public void act() {
        tickCount = tickCount + 1;
        if(tickCount == 50) {
            spawnBrick();
            tickCount = 0;
        }
    }
    public void spawnBrick(){
        //spawn a brick at random location
        int randomX = Greenfoot.getRandomNumber(600);
        addObject(new Brick(),randomX, 40);
        
    }
    
    public void spawnPlayer() {
        //spawn a player at a set location
        
        //addObject(new Dragon(),300,388);
        addObject(new MarioLikePhysicsDragon(),300,388);
    }
}
