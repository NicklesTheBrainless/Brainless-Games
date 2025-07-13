package ui;

import base.panel.ProgramPanel;
import games.bouncing_ball_game.BouncingBallGame;
import games.Game;
import games.ping_pong_game.PingPongGame;
import utils.objects.ProgramObject;

import java.awt.*;

public class MenuManager implements ProgramObject {

    ProgramPanel panel;

    Game[] games = { new BouncingBallGame(), new PingPongGame() };
    RectButton[] gameButtons = new RectButton[games.length];

    public MenuManager(ProgramPanel panel) {
        this.panel = panel;

        for (int i = 0; i < games.length; i++) {

            int buttonX = (i % 2) * 350 + 100;
            int buttonY = (i / 2) * 350 + 100;

            final int finalGameIndex = i;
            Runnable onClicked = () -> this.startGame(games[finalGameIndex]);

            RectButton gameButton = new RectButton(panel.mouseButtonH, panel.mouseMotionH,
                    buttonX, buttonY, 250, 250, games[i].icon, onClicked);

            gameButtons[i] = gameButton;
        }
    }



    @Override
    public void update() {
        for (RectButton button : gameButtons)
            button.update();
    }

    @Override
    public void draw(Graphics2D g2) {
        for (RectButton button : gameButtons)
            button.draw(g2);
    }



    private void startGame(Game game) {
        panel.game = game;
        game.onStart();
    }

}
