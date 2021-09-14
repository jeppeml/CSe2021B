import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    private String labelText = "tesT";
    private GreenfootImage img = new GreenfootImage(100,40);
    
    public Label(){
        super();
        act();
    }
    
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(100,40);
        img.setColor(Color.BLACK);
        //img.setTransparency(255);
        img.drawString(labelText, 0,0);
        setImage(img);
    }    
}
