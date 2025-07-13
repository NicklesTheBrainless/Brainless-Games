package games.ping_pong_game;

import java.awt.*;

public class Paddle {

    private int x, y;
    private final int width = 10;
    private final int height = 80;
    private final int speed = 4;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        y -= speed;
        if (y < 0)
            y = 0;
    }

    public void moveDown() {
        y += speed;
        if (y + height > 800)
            y = 800 - height;
    }

    public boolean intersects(int bx, int by, int bw, int bh) {
        return (bx < x + width) && (bx + bw > x) && (by < y + height) && (by + bh > y);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, width, height);
    }
}
