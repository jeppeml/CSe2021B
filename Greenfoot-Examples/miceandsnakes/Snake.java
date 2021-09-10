import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Mouse closestMouse = getClosest(); 
        if(closestMouse != null)
        {
            turnTowards(closestMouse.getX(), closestMouse.getY());
            checkAndEatMouse(closestMouse);
            move(2);
        }
    }    

    private void checkAndEatMouse(Mouse m){
        if(intersects(m)){
            World w = getWorld();
            w.removeObject(m);
        }
    }

    private Mouse getClosest(){
        List<Mouse> mice = getObjectsInRange(1500, Mouse.class);

        Mouse closestMouse = null;
        double closest = 100000;

        for(Mouse m: mice){ // For each mouse in the list of mice

            double dx = Math.abs(m.getX() - getX());
            double dy = Math.abs(m.getY() - getY());

            double distance = Math.sqrt(dx*dx+dy*dy);
            if(distance<closest){
                closestMouse = m;
                closest = distance;
            }
        }
        return closestMouse;
    }
}
