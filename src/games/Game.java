package games;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Game {

    public BufferedImage icon;

    public int screenWidth  = 800;
    public int screenHeight = 800;

    public abstract void onStart();
    public abstract void update();
    public abstract void draw(Graphics2D g2);
}
