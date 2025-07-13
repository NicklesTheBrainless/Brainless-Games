package games.ping_pong_game;

import java.awt.*;

public class Ball {

    private int x, y;
    private int vx = 5;
    private int vy = 3;
    private final int radius = 8;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update(int screenWidth, int screenHeight, Paddle left, Paddle right) {

        x += vx;
        y += vy;

        if (y - radius < 0 || y + radius > screenHeight)
            vy = -vy;

        boolean collidesLeft  = left.intersects(x - radius, y - radius, radius * 2, radius * 2);
        boolean collidesRight = right.intersects(x - radius, y - radius, radius * 2, radius * 2);
        if (collidesLeft || collidesRight)
            vx = -vx;


        if (x + radius < 0 || x - radius > screenWidth) {
            x = screenWidth / 2;
            y = screenHeight / 2;
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
