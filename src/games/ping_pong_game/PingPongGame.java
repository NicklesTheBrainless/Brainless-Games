package games.ping_pong_game;

import games.Game;

import java.awt.*;

import static utils.ResourceUtils.readImage;

public class PingPongGame extends Game {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;

    @Override
    public void onStart() {

        screenWidth  = 800;
        screenHeight = 500;

        ball = new Ball(screenWidth / 2, screenHeight / 2);
        leftPaddle = new Paddle(30, screenHeight / 2 - 40);
        rightPaddle = new Paddle(screenWidth - 40, screenHeight / 2 - 40);

        icon = readImage("/game_icons/ping_pong.png");
    }

    @Override
    public void update() {
        // TODO: add controls here, with the KeyHandler, this needs some refactoring in other classes
        ball.update(screenWidth, screenHeight, leftPaddle, rightPaddle);
        leftPaddle.moveUp();
        rightPaddle.moveDown();
    }

    @Override
    public void draw(Graphics2D g2) {

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, screenWidth, screenHeight);

        ball.draw(g2);
        leftPaddle.draw(g2);
        rightPaddle.draw(g2);
    }
}
