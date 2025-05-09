import java.awt.*;
import javax.swing.*;

public class Board extends JPanel implements Palette, Runnable{
    private double genesisTime;

    public Board(){
        super();
        genesisTime = System.currentTimeMillis();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    private int getTime(){
        return (int) (System.currentTimeMillis() - genesisTime);
    }

    public void run(){
        repaint();
    }
}