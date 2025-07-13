package games.bouncing_ball_game;

import games.Game;

import java.awt.*;

import static utils.ResourceUtils.readImage;

public class BouncingBallGame extends Game {

    private int x, y;
    private int vx, vy;
    private int radius;
    private Color color;

    public BouncingBallGame() {
        icon = readImage("/game_icons/bouncing_ball.png");
    }



    @Override
    public void onStart() {

        radius = 20;
        x = screenWidth / 2;
        y = screenHeight / 2;
        vx = 13;
        vy = 9;
        color = new Color(217, 87, 99);
    }

    @Override
    public void update() {

        x += vx;
        y += vy;

        if (x - radius < 0   ||   x + radius > screenWidth)
            vx = -vx;
        if (y - radius < 0   ||   y + radius > screenHeight)
            vy = -vy;
    }

    @Override
    public void draw(Graphics2D g2) {

        g2.setColor(color);
        g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}