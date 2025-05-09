import java.awt.*;

public interface Entity extends Runnable {
    public void run();
        
    public int getX();

    public int getY();

    public Color getPixel(int x, int y);
}