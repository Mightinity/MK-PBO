import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnAtEdge();
    }
    
    /**
     * turnAtEdge - turns the actor 180 degrees if at the edge of the world
     */
    public void turnAtEdge()
    {
        if(isAtEdge())
        {
           turn (180);
        }//endif
    }
}
