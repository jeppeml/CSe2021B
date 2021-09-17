import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Counter counter;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        counter = new Counter("amount of wombats: ");
        addObject(counter, 450,20);
        String inputValue = JOptionPane.showInputDialog("Please input a value");
counter.setPrefix(inputValue);
    }
    
    public void act(){
        counter.setValue(Wombat.getAmountOfWombats());
    }
}
