import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BeeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeeWorld extends World
{
    private int score;
    private Bee bee = new Bee();

    /**
     * Constructor for objects of class BeeWorld.
     * 
     */
    public BeeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public int getScore(){
        return score;
    }//end method getScore;
    
    public void updateScore(){
        score++;
        showText("Score : " + score, 60, 390);
    }//end method updateScore
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(bee,150,100);
        addObject(new Spider(),510,360);

        int i = 0;
        while(i<10){
            int xCoord = Greenfoot.getRandomNumber(this.getWidth());
            int yCoord = Greenfoot.getRandomNumber(this.getHeight());
            addObject(new Fly(1,90), xCoord,yCoord);
            i=i+1;
        }//endwhile
    }//end method prepare
    
    public Bee getBee(){
        return bee;
    }//end method getBee
}
