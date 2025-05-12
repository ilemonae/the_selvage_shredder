import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpriteEditor extends JFrame implements Palette{
    private static final int SPRITE_WIDTH = 16; // Width of the sprite in pixels
    private static final int SPRITE_HEIGHT = 16; // Height of the sprite in pixels
    private final int PIXEL_SIZE = 20; // Size of each pixel in the editor
    public static Color[][] spriteGrid = new Color[SPRITE_WIDTH][SPRITE_HEIGHT]; // Sprite grid
    private Color selectedColor = Color.BLACK; // Default selected color
    public Sprite sprite;

    public SpriteEditor() {
        sprite = new Sprite();
        sprite.fill(cl);
        setTitle("Sprite Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SPRITE_WIDTH * PIXEL_SIZE + 200, SPRITE_HEIGHT * PIXEL_SIZE + 50);
        setLayout(new BorderLayout());

        // Initialize sprite grid with a default color
        for (int i = 0; i < SPRITE_WIDTH; i++) {
            for (int j = 0; j < SPRITE_HEIGHT; j++) {
                spriteGrid[i][j] = cl;
            }
        }
        

        // Canvas for drawing the sprite
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < SPRITE_WIDTH; i++) {
                    for (int j = 0; j < SPRITE_HEIGHT; j++) {
                        g.setColor(spriteGrid[i][j]);
                        g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
                        g.setColor(Color.BLACK);
                        g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
                    }
                }
            }
        };
        canvas.setPreferredSize(new Dimension(SPRITE_WIDTH * PIXEL_SIZE, SPRITE_HEIGHT * PIXEL_SIZE));
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / PIXEL_SIZE;
                int y = e.getY() / PIXEL_SIZE;
                if (x >= 0 && x < SPRITE_WIDTH && y >= 0 && y < SPRITE_HEIGHT) {
                    spriteGrid[x][y] = selectedColor;
                    canvas.repaint();
                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                String str = "Sprite genSprite = new Sprite();";
                 str+= "genSprite.clear();";
             for (int i = 0; i < spriteGrid.length; i++){
                str+="ArrayList<Color> subl" +i + " = new ArrayList<Color>(); ";
                 for (Color c : spriteGrid[i]){
                   str+= "subl" + i + ".add(new Color(" + c.getRed() + "," +c.getGreen() + "," + c.getBlue() + "));";
            }
            str+="genSprite.add(subl" + i+ ");";
        }
        System.out.println(str);
            }
        });

        // Color palette for selecting colors
        JPanel colorPalette = new JPanel();
        colorPalette.setLayout(new GridLayout(2, 5));
        Color[] colors = {cl, pr, bu, lg, pt, dv, tu, nv, rd};
        for (int i = 0; i<colors.length; i++) {
            final Color c = colors[i];
            JButton colorButton = new JButton();
            colorButton.setBackground(colors[i]);
            colorButton.setPreferredSize(new Dimension(30, 30));
            colorButton.addActionListener(e -> selectedColor = c);
            colorPalette.add(colorButton);
        }

        // Add components to the frame
        add(canvas, BorderLayout.CENTER);
        add(colorPalette, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SpriteEditor::new);
        
        
    }
}