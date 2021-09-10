import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int lives = 3;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeys();
        checkIfEnemy();
        checkIfPowerUp();
        updateScoreText();
        // Add your action code here.
    }    
    
    private void checkKeys(){
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX(), getY()-1);
        }
        if(Greenfoot.isKeyDown("z"))
        {
            setLocation(getX(), getY()+1);
        }
    }
    
    private void updateScoreText(){
        MyWorld mw = getWorldOfType(MyWorld.class);
        mw.setLivesText("Score : " + lives);
    }
    
    private void checkIfPowerUp(){
        Actor powerUp = getOneIntersectingObject(PowerUp.class);
        
        if(powerUp!=null){
            getWorld().removeObject(powerUp);
            lives++;
        }
        
    }
    
    private void checkIfEnemy(){
        Actor enemy = getOneIntersectingObject(Enemy.class);
        
        if(enemy!=null){
            getWorld().removeObject(enemy);
            lives--;
        }
        
    }
}
