import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Classroom extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Classroom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 400, 1); 
        
        // TYPE NAME = new TYPE
        Table table1 = new Table(); // creates a Table object/instance
        addObject(table1,50,50);
        table1.setRotation(90);
        //table1.speed = 5;
        
        Table table2 = new Table(); // creates a Table object/instance
        addObject(table2,150,50);
        table2.setRotation(90);
        table2.speed = 10;
        
    }
}
