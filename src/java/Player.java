import java.awt.*;

public class Player implements Entity, Palette{ // player class - an ordinary entity, the only departure from the location, sprite, behaviour pattern is that it has acess to the key-detection in board
    private int x;
    private int y;
    private Board board;
    private Sprite sprite;

    public Player(int x, int y, Sprite sprite){ // constructor — essentially just location and sprite
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    @Override
    public String run(){ // run — behaviour, key detection and physics essentially, also checks for game over
        if (board.getKeySpace()){
            jump();
        }
        return toString() + " running";
    }

    @Override
    public int getX(){ // get x/y — for telling board where to draw things
        return x;
    }

    @Override
    public int getY(){
        return y;
    }

    @Override
    public Color getPixel(int x, int y){ // get pixel — for telling board when and what colour to draw
        return sprite.getPixel(x, y);
    }

    @Override
    public void addBoard(Board board){ // add board — get a reference to the board for key detection
        this.board = board;
    }

    public void jump(){
        sprite.fill(bu);
    }
}