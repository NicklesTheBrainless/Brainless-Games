package games;

import base.listeners.KeyHandler;
import base.listeners.MouseButtonHandler;
import base.listeners.MouseMotionHandler;
import base.listeners.MouseWheelHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Game {

    public KeyHandler keyH = new KeyHandler();
    
    public MouseButtonHandler mouseButtonH = new MouseButtonHandler();
    public MouseMotionHandler mouseMotionH = new MouseMotionHandler();
    public MouseWheelHandler  mouseWheelH  = new MouseWheelHandler();

    public BufferedImage icon;

    public int screenWidth  = 800;
    public int screenHeight = 800;

    public abstract void onStart();
    public abstract void update();
    public abstract void draw(Graphics2D g2);
}
