import java.awt.*;

public class Obstacle implements Entity{// obstacle class — an entity
    private int x;
    private Board board;
    private int timeToMoveNext;
    private static int delay = 100; // delay between moves
    private Sprite sprite;

    public Obstacle(Board board, Sprite sprite){
        this.x = 9;
        this.board = board;
        this.sprite = sprite;
        timeToMoveNext = board.getTime() + delay;
    }

    @Override
    public void addBoard(Board board){
        
    }

    @Override
    public String run(){
        if (timeToMoveNext <= board.getTime()){
            x--;
            timeToMoveNext = board.getTime() + delay;
        }
        board.playerDown(this, x, 6);
        return "Obstacle is running";
    }// run — essentially rushes forward toward player until it goes off the screen then deletes itself
    
    @Override
    public int getX(){
        return x;
    }

    @Override
    public int getY(){
        return 6;
    } // get y — for telling board where to draw things
    // get x/y — for telling board where to draw things
    @Override
    public Color getPixel(int x, int y){ // get pixel — for telling board when and what colour to draw
        return sprite.getPixel(x, y);
    }

    static public int getDelay(){
        return delay;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    } // set sprite — for changing sprites
}
