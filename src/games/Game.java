package games;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Game {

    public BufferedImage icon;

    public abstract void onStart();
    public abstract void update();
    public abstract void draw(Graphics2D g2);
}
