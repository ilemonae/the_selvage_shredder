import java.awt.*;

public class Player implements Entity{
    private int x;
    private int y;
    private Board board;
    private Sprite sprite;

    public Player(Board board, int x, int y, Sprite sprite){
        this.board = board;
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    @Override
    public void run(){
        
    }

    @Override
    public int getX(){
        return x;
    }

    @Override
    public int getY(){
        return y;
    }

    @Override
    public Color getPixel(int x, int y){
        return sprite.getPixel(x, y);
    }
}