import javax.swing.*;
import java.awt.GraphicsEnvironment;
import java.awt.*;

//window class — essentially just a frame and a board

public class Window implements Runnable{
    JFrame frame;
    Board board;

    public Window(){ // constructor — sets everything up
        frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        device.setFullScreenWindow(frame);

        board = new Board();
        board.setPreferredSize(new Dimension(1441, 901));
        board.setBackground(Color.WHITE);

        frame.add(board);
        frame.pack();
        frame.setVisible(true);
    }

    public String run(){
        board.run(); // run — most of the game is called here
        return toString() + " running";
    }
    
}