package base.panel;

import base.listeners.InputHandler;
import games.Game;
import ui.MenuManager;

import javax.swing.*;
import java.awt.*;

import static base.setting.Settings.*;

public class ProgramPanel extends BasePanel {

    // input listeners (keyboard + mouse)
    public InputHandler input = new InputHandler(this);

    // menu (to select a game to play)
    MenuManager menuM = new MenuManager(this);

    // current game
    public Game game = null;

    public ProgramPanel() {

        super(MAX_FPS);

        this.setPreferredSize(new Dimension(STANDARD_SCREEN_WIDTH, STANDARD_SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);
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
        input.update();
    }

    @Override
    protected void draw(Graphics2D g2) {

        if (game == null)
            menuM.draw(g2);
        else
            game.draw(g2);
    }

}