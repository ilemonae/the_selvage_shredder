import java.awt.*;

public interface Palette{ // pallette interface — palatte is perhaps not the best name... it is the colours and "rules" for handling drawing...
    Color cl = new Color(0, 0, 0, 0);
    Color bl = new Color(0, 0, 0);

    int PIXEL_WIDTH = 7;
    int PIXEL_HEIGHT = 7;
    int SPRITE_WIDTH = 16;
    int SPRITE_HEIGHT = 16;
}