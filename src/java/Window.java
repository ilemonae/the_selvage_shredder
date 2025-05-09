import javax.swing.*;
import java.awt.*;

public class Window implements Runnable{
    JFrame frame;
    Board board;

    public Window(){
        frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board();
        board.setPreferredSize(new Dimension(1441, 901));
        board.setBackground(Color.WHITE);

        frame.add(board);
        frame.pack();
        frame.setVisible(true);
    }

    public void run(){
        board.run();
    }
    
}