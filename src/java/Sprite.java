import java.awt.*;
import java.util.*;

public class Sprite extends ArrayList<ArrayList<Color>> implements Palette{ //sprite class — essentially a glorified array of colours
    public Sprite(){
        super();
        for(int i = 0; i < SPRITE_HEIGHT; i++){ // constructor — initialises with correct dimensions
            add(new ArrayList<Color>(SPRITE_WIDTH));
            for(int j = 0; j < SPRITE_HEIGHT; j++){
                get(i).add(cl);
            }
        }
    }

    public Color getPixel(int x, int y){ // get + set pixel — i like these getters and setters b/c get.get/set bothers me
        return get(x).get(y);
    }

    private void setPixel(int x, int y, Color color){
        get(x).set(y, color);
    }

    public void fill(Color color){ // fill — random tool
        for(int i = 0; i < SPRITE_WIDTH; i++){
            for(int j = 0; j < SPRITE_HEIGHT; j++){
                setPixel(i,j, color);
            }
        }
    }
}