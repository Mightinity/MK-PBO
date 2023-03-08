import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spider here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Bug
{
    /**
     * Act - do whatever the Spider wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        turnAtEdge();
        BeeWorld myWorld = (BeeWorld) getWorld();
        Bee bee = myWorld.getBee();
        this.turnTowards(bee.getX(), bee.getY());
    }//end method act    
}//end class Spider
