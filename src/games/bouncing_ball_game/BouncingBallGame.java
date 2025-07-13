package games.bouncing_ball_game;

import games.Game;

import java.awt.*;

import static base.setting.Settings.SCREEN_HEIGHT;
import static base.setting.Settings.SCREEN_WIDTH;
import static utils.ResourceUtils.readImage;

public class BouncingBallGame extends Game {

    private int x, y;
    private int vx, vy;
    private int radius;
    private Color color;

    public BouncingBallGame() {
        icon = readImage("/game_icons/bouncing_ball_game.png");
    }



    @Override
    public void onStart() {

        radius = 20;
        x = SCREEN_WIDTH / 2;
        y = SCREEN_HEIGHT / 2;
        vx = 13;
        vy = 9;
        color = new Color(217, 87, 99);
    }

    @Override
    public void update() {

        x += vx;
        y += vy;

        if (x - radius < 0   ||   x + radius > SCREEN_WIDTH)
            vx = -vx;
        if (y - radius < 0   ||   y + radius > SCREEN_HEIGHT)
            vy = -vy;
    }

    @Override
    public void draw(Graphics2D g2) {

        g2.setColor(color);
        g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}