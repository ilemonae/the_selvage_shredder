import java.awt.*;

public interface Entity extends Runnable { // entity class — interface for everything on the screen. essentially has a location, sprite, and behaviour
    public String run();
        
    public int getX();

    public int getY();

    public Color getPixel(int x, int y);
 
    public void addBoard(Board board);
}