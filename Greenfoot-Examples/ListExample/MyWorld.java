import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; // List and ArrayList

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        List<Horse> stable = new ArrayList();
        
        for(int i = 0;i < 4;i++){
            Horse h = new Horse();
            stable.add(h);
            addObject(h, 50,50+100*i);
        }
        
        double fastestSpeed = 0;
        Horse fastestHorse = null;
        for(int i=0; i<stable.size();i++){
            Horse h = stable.get(i);
            double horseSpeed = h.getSpeed();
            if(horseSpeed>fastestSpeed)
            {
                fastestHorse = h;
                fastestSpeed = horseSpeed;
            }
        }
        // Smoothmover
        fastestHorse.getImage().scale(50,50);
    }
}
