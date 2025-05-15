import java.awt.*;
import java.util.*;

public class Player implements Entity, Palette, UsesPhysics{ // player class - an ordinary entity, the only departure from the location, sprite, behaviour pattern is that it has acess to the key-detection in board
    private int x;
    private int y;
    private Board board;
    private ArrayList<Sprite> spriteSheet;
    private Sprite sprite;
    private Physics physics;

    public Player(int x, int y, ArrayList<Sprite> spriteSheet){ // constructor — essentially just location and sprite
        this.x = x;
        this.y = y;
        this.spriteSheet = spriteSheet;
        this.sprite = spriteSheet.get(0); // default sprite
    }

    public void addPhysics(Physics physics){ // add physics — get a reference to the physics for gravity
        this.physics = physics;
    }

    public void setSprite(ArrayList<Sprite> spriteSheet){ // set sprite — for changing sprites
        this.spriteSheet = spriteSheet;
    }


    @Override
    public String run(){// run — behaviour, key detection and physics essentially, also checks for game over
        if (board.getKeySpace()){
            jump();
        }
        physics.run();
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
    public void setY(int y){ // set y — for telling board where to draw things
        this.y = y;
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
        physics.jump();
    }
    @Override
    public void setSprite(int i){
        sprite = spriteSheet.get(i); // set sprite — for changing sprites
    }
}