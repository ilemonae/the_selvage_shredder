import java.awt.*;
import java.util.*;

public class Sprite extends ArrayList<ArrayList<Color>> implements Palette{
    public Sprite(){
        super();
    }

    public Color getPixel(int x, int y){
        return get(x).get(y);
    }
}