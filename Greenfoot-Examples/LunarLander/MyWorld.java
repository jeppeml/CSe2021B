import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Label lbl = new Label("Careful", 40);
    private int wormsEaten = 0;
    private Label wormsLbl = new Label("Worms: 0", 40); 
    private int acts = 0;
    
    public void addWorms(){
        wormsEaten++;
        wormsLbl.setValue("Worms: " + wormsEaten);
    }
    
    
    public void act(){
        
        acts++;
        if(acts>3*30){
            spawnShip();
            acts=0;
        }
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 600, 1); 
        addObject(lbl, 150,40);
        addObject(wormsLbl, 150, 100);
        spawnSurface();
        
        for(int i=0; i<100;i++){
            spawnShip();
        }
        
        spawnHorse(3);
    }
    
    public void spawnHorse(int speed){
        Horse horse = new Horse(speed);
        addObject(horse, 
                Greenfoot.getRandomNumber(400), 
                Greenfoot.getRandomNumber(600));
    }
    
    public void spawnSurface(){
        MoonSurface surface = new MoonSurface();
        GreenfootImage img = surface.getImage();
        img.scale(400, 100);
        addObject(surface, 200, 600);
    }
    
    public void spawnShip(){
         //ThrustFlame flame = new ThrustFlame(ship);
        //addObject(flame, ship.getX(), ship.getY());
        
        Ship myShip = new Ship();
            addObject(myShip, 
                Greenfoot.getRandomNumber(400), 
                Greenfoot.getRandomNumber(600));
    }
    
    public void setText(String str){
        lbl.setValue(str);
    }
    
    public void showFlames(){
        Flames flames = new Flames();
        addObject(flames, 230, 382);
    }
}
