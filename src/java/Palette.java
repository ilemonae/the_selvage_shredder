import java.awt.*;

public interface Palette{ // pallette interface — palatte is perhaps not the best name... it is the colours and "rules" for handling drawing...
    Color cl = new Color(255, 255, 255, 0);
    Color bl = new Color(0, 0, 0);
    Color bu = new Color(167, 199, 231);
    Color lg = new Color(165, 187, 159);
    Color pt = new Color(233,233,233);
    Color dv = new Color(217, 201, 179);
    Color tu = new Color(190,153, 134);
    Color nv = new Color(62, 71, 114);
    Color pr = new Color(250,160,160);
    Color rd = new Color(255,105,97);

    int PIXEL_WIDTH = 7;
    int PIXEL_HEIGHT = 7;
    int SPRITE_WIDTH = 16;
    int SPRITE_HEIGHT = 16;
}