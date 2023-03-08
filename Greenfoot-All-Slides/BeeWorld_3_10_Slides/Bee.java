import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    private GreenfootImage[] images = new GreenfootImage[4];
    private int currentImage;
    private int score;
    private int lives;
    
    public Bee(){
        int i = 0;
        while(i<4){
            images[i] = new GreenfootImage("bee" + (i+1) + ".png");
            i = i+1;
        }//endwhile
        currentImage = 0;
        score = 0;
        lives = 3;
    }//end constructor
    
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animateBee();
        handleMovement();
        turnAtEdge();
        catchFly();
        caughtBySpider();
    }//end method act

    /**
     * caughtBySpider - Resets the location of the Bee and reduces the lives variable by 1
     */
    private void caughtBySpider(){
        if(isTouching(Spider.class)){
            setLocation(20,20);
            lives--;
            if(lives<0){
                endGame();
            }//endif
        }//endif
    }//end method caughtBySpider
    
    /**
     * endGame - ends the game
     */
    private void endGame(){
        Greenfoot.stop();
    }//end method endGame
    
    /**
     * animateBee - changes the images for the bee
     */
    private void animateBee(){
        if(currentImage == 3)
           currentImage = 0;
        else
           currentImage++;
        //endif   
        setImage(images[currentImage]);
    }//end method animateBee
    
    /**
     * turnAtEdge - moves the object if it is at the edge
     */
    private void turnAtEdge(){
        if(atRightEdge()){
            setLocation(6, getY());
        }
        else if(atBottomEdge()){
            setLocation(getX(), 6);
        }
        else if(atLeftEdge()){
            setLocation(getWorld().getWidth()-20, getY());
        }
        else if(atTopEdge()){
            setLocation(getX(), getWorld().getHeight()-20);
        }//endif
    }//end method turnAtEdge
    
    /**
     * handleMovement - moves the object forward a given amount
     */
    private void handleMovement(){
        move(1);
        if(Greenfoot.isKeyDown("left")){
            turn(-2);
        }else if(Greenfoot.isKeyDown("right")){
            turn(2);
        }//endif
    }//end method handleMovement
    
    /**
     * catchFly2 - if the Bee touches a fly the fly is removed
     */
    private void catchFly2(){
        Actor fly = getOneIntersectingObject(Fly.class);
        if(fly != null){
            getWorld().removeObject(fly);
            Greenfoot.playSound("slurp.wav");
        }//endif
    }//end method catchFly2
    
    /**
     * catchFly - if the Bee touches a fly the fly is removed
     * A souond is played, the score increased and a new fly is added to the game
     */
    private void catchFly(){
        if(isTouching(Fly.class)){
            removeTouching(Fly.class);
            Greenfoot.playSound("slurp.wav");
            score++;
            getWorld().addObject(new Fly(4, 90), Greenfoot.getRandomNumber(getWorld().getWidth()),
                                            Greenfoot.getRandomNumber(getWorld().getHeight()));
        }//endif
    }//end method catchFly
    
    /**
     * updateScore - Increases the score and displayes the new score on screen
     */
    private void updateScore(){
        BeeWorld myWorld = (BeeWorld) getWorld();
        myWorld.updateScore();
    }//end method updateScore
    
    /**
     * atLeftEdge - Test if we are close to the left edge of the world
     * Return true if the object is
     */
    private boolean atLeftEdge()
    {
        if(getX() < 6)
            return true;
        else
            return false;
        //endif    
    }//end method atLeftEdge  
    
    /**
     * atTopEdge - Test if we are close to the top edge of the world
     * Return true if the object is
     */
    private boolean atTopEdge()
    {
        if(getY() < 6)
            return true;
        else
            return false;
        //endif    
    }//end method atTopEdge  
    
    /**
     * atBottomEdge - Test if we are close to the bottom edge of the world
     * Return true if the object is
     */
    private boolean atBottomEdge()
    {
        if(getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
        //endif    
    }//end method atBottomEdge    
    
    /**
     * atRightEdge - Test if we are close to the right edge of the world
     * Return true if the object is
     */
    private boolean atRightEdge()
    {
        if(getX() > getWorld().getWidth() - 20)
            return true;
        else
            return false;
        //endif    
    }//end method atRightEdge
}//end class Bee
