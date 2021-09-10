


import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Horse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse extends Actor  
{

    /**
     * Constructor for objects of class Horse
     */
    private int speed;
    private int acts;
    public Horse(){ // Constructor
        this(1); // default speed
    }
    public Horse(int speed)
    {
        this.speed=speed;
        acts=0;
    }

    public void act(){
        List<Ship> ships = getObjectsInRange(1000, Ship.class);
        Ship closestShip=null;
        double shortestDistance=1000;
        for(Ship ship: ships){
            double dx = Math.abs(getX()-ship.getX());
            double dy = Math.abs(getY()-ship.getY());
            double distance = Math.sqrt(dx*dx+dy*dy);
            if(shortestDistance>distance){
                closestShip = ship;
                shortestDistance = distance;
            }
        }
        if(closestShip!=null){
            turnTowards(closestShip.getX(), closestShip.getY());
            move(speed);
            if(intersects(closestShip)){
                getWorld().removeObject(closestShip);
               // ((MyWorld)getWorld()).spawnShip();
                grow();
                MyWorld mw = (MyWorld)getWorld();
                mw.addWorms();
            }
        }
        if(acts>30*3){
            shrink();
            acts=0;
        }
        acts++;
    }
    
    private void grow(){
 
        getImage().scale(
            (int)(getImage().getWidth()*1.1), 
            (int)(getImage().getHeight()*1.1));
    }
    
    private void shrink(){
        if(getImage().getWidth()>20 && getImage().getHeight()>20)
            getImage().scale(
                (int)(getImage().getWidth()*0.9), 
                (int)(getImage().getHeight()*0.9));
    }

}
