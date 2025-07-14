package base.panel;

import base.listeners.KeyHandler;
import base.listeners.MouseButtonHandler;
import base.listeners.MouseMotionHandler;
import base.listeners.MouseWheelHandler;
import games.Game;
import ui.MenuManager;

import javax.swing.*;
import java.awt.*;

import static base.setting.Settings.*;

public class ProgramPanel extends BasePanel {

    // keyboard input listener
    public KeyHandler keyH = new KeyHandler();

    // mouse input listeners
    public MouseButtonHandler mouseButtonH = new MouseButtonHandler();
    public MouseMotionHandler mouseMotionH = new MouseMotionHandler();
    public MouseWheelHandler  mouseWheelH  = new MouseWheelHandler();

    // menu
    MenuManager menuM = new MenuManager(this);

    // current game
    public Game game = null;

    public ProgramPanel() {

        super(MAX_FPS);

        this.setPreferredSize(new Dimension(STANDARD_SCREEN_WIDTH, STANDARD_SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addKeyListener(keyH);

        this.addMouseListener(mouseButtonH);
        this.addMouseMotionListener(mouseMotionH);
        this.addMouseWheelListener(mouseWheelH);
    }



    @Override
    protected void update() {

        if (game == null){
            menuM.update();
        } else {
            game.update();
            SwingUtilities.getWindowAncestor(this).setSize(game.screenWidth, game.screenHeight);
        }

        // update listeners
        keyH.update();
        mouseButtonH.update();
        mouseMotionH.update();
        mouseWheelH.update();
    }

    @Override
    protected void draw(Graphics2D g2) {

        if (game == null)
            menuM.draw(g2);
        else
            game.draw(g2);
    }

}