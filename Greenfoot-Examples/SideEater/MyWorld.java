import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Label scoreLbl = new Label("Lives: 3", 38);
    private int counter = 0;
    private int counterPowerUps = 0;
    private int level = 1;
    Player p = new Player();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        
        addObject(p, 50,200);
        addObject(scoreLbl, 200,20);
    }

    public void act(){
        level = 
        if(counter>5*30/level){
            Enemy e = new Enemy();
            addObject(e, getWidth(), 
                Greenfoot.getRandomNumber(getHeight()));
            counter = 0;
        }
        counter++;
        
        if(counterPowerUps>5*30/level){
            PowerUp p = new PowerUp();
            addObject(p, getWidth(), 
                Greenfoot.getRandomNumber(getHeight()));
            counterPowerUps = 0;
        }
        counterPowerUps++;
    }

    public void setLivesText(String text){
        scoreLbl.setValue(text);
    }

}
