import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fly here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fly extends Bug
{
    private int speed;
    
    /**
     * Fly - sets the intial values of the fly
     */
    public Fly(int maxSpeed, int direction){
        speed = (Greenfoot.getRandomNumber(maxSpeed)+1);
        setRotation(direction);
    }//end constructor
    
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        randomMovement();
        turnAtEdge();
    }//end method act    
    
    private void randomMovement(){
        move(speed);
        if(Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }//endif
    }//end method randomMovement
}//end class Fly
