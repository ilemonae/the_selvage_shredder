import java.awt.*;
import javax.swing.*;

// board class — subclasses panel; essentially handles everything inside the window... most of the game is here, it's like the "real" main. the board is has quantised locations, like an ascii art game except it's not ascii... made this descision b/c otherwise the scale to speed up development

public class Board extends JPanel implements Palette, Runnable{ 
    private double genesisTime;
    private static double fps = 60;
    private static int localOriginX = 160;
    private static int localOriginY = 58;
    private static int height = 7;
    private static int width = 10;
    Player p;
    
    public Board(){ //constructor - sets everything up, initialises entities etc. (time also starts here);
        super();
        genesisTime = System.currentTimeMillis();



        Sprite s = new Sprite();
        s.fill(bl);
        p =  new Player(0,0,s);



    }

    @Override
    public void paintComponent(Graphics pen){  //override paint component — everything gets drawn here
        super.paintComponent(pen);

        pen.fillRect(0,0,7,7);
        pen.drawRect(0,0,7*16, 7*16);
        drawEntity(p, pen);
        pen.drawRect(localOriginX-1,localOriginY - 1,PIXEL_WIDTH*SPRITE_WIDTH*width + 1, PIXEL_HEIGHT*SPRITE_HEIGHT*height + 1);
    }

    private int getTime(){ // get time — time is kept track here – timer begins when board constructer is called
        return (int) (System.currentTimeMillis() - genesisTime);
    }

    public String run(){ // run — meat of what is called in the loop in main. entity behaviours, key detection, etc.
        if (getTime() % (1/(fps/1000)) == 0)
            repaint();
            return toString() + " running";
    }

    private int getRealX(int boardX, int pixelX){ // get x/y — figureing out where to draw things on the screen relative to the quantised positions on the board
        return (boardX * SPRITE_WIDTH * PIXEL_WIDTH) + localOriginX + (PIXEL_WIDTH * pixelX) - 1;
    }

    private int getRealY(int boardY, int pixelY){
        return (boardY * SPRITE_HEIGHT * PIXEL_WIDTH) + localOriginY + (PIXEL_HEIGHT * pixelY) - 1;
    }

    private void drawEntity(Entity entity, Graphics pen){ // draw entity — everything on the board can be drawn with this thanks to entity interface
        for (int pixelX = 0; pixelX < SPRITE_WIDTH; pixelX++){
            for (int pixelY = 0; pixelY < SPRITE_HEIGHT; pixelY++){
                pen.setColor(entity.getPixel(pixelX,pixelY));
                int realX = getRealX(entity.getX(), pixelX);
                int realY = getRealY(entity.getY(), pixelY);
                pen.fillRect(realX, realY, PIXEL_WIDTH, PIXEL_HEIGHT);
            }
        }
    }

    // get key — player behaviour is influenced by input, hence reference is needed

    // key pressed/released etc. — updates get key

    // spawn obstacle — initiallises obsticles at specific but also to an extent randomized intervals
    
    // calculate score — score based on current time

    // draw score - draws scoreboard
}
