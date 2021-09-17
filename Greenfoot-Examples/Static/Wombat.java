import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wombat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wombat extends Actor
{
    private int health;
    private static int amountOfWombats;
    private String name;
    
    public Wombat(int health){
        this.health = health;
        amountOfWombats = amountOfWombats + 1;

    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public static int getAmountOfWombats(){
        return amountOfWombats;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
