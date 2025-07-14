package base.listeners;

import base.listeners.keyboard.KeyBoardHandler;
import base.listeners.mouse.MouseButtonHandler;
import base.listeners.mouse.MouseMotionHandler;
import base.listeners.mouse.MouseWheelHandler;
import base.panel.ProgramPanel;

public class InputHandler {

    public KeyBoardHandler    keyBoard    = new KeyBoardHandler();
    public MouseButtonHandler mouseButton = new MouseButtonHandler();
    public MouseMotionHandler mouseMotion = new MouseMotionHandler();
    public MouseWheelHandler  mouseWheel  = new MouseWheelHandler();

    public InputHandler(ProgramPanel panel) {
        panel.addKeyListener(keyBoard);
        panel.addMouseListener(mouseButton);
        panel.addMouseMotionListener(mouseMotion);
        panel.addMouseWheelListener(mouseWheel);
    }

    public void update() {
        keyBoard.update();
        mouseButton.update();
        mouseMotion.update();
        mouseWheel.update();
    }

}
