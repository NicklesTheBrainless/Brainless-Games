package base.listeners.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseButtonHandler implements MouseListener {

    public boolean leftPressed, middlePressed, rightPressed;
    public boolean leftJustPressed, middleJustPressed, rightJustPressed;
    public boolean leftJustReleased, middleJustReleased, rightJustReleased;
    public boolean leftJustClicked, middleJustClicked, rightJustClicked;

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> leftJustClicked = true;
            case MouseEvent.BUTTON2 -> middleJustClicked = true;
            case MouseEvent.BUTTON3 -> rightJustClicked = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> {
                leftPressed = true;
                leftJustPressed = true;
            }
            case MouseEvent.BUTTON2 -> {
                middlePressed = true;
                middleJustPressed = true;
            }
            case MouseEvent.BUTTON3 -> {
                rightPressed = true;
                rightJustPressed = true;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1 -> {
                leftPressed = false;
                leftJustReleased = true;
            }
            case MouseEvent.BUTTON2 -> {
                middlePressed = false;
                middleJustReleased = true;
            }
            case MouseEvent.BUTTON3 -> {
                rightPressed = false;
                rightJustReleased = true;
            }
        }
    }

    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}



    public void update() {
        leftJustClicked = middleJustClicked = rightJustClicked = false;
        leftJustPressed = middleJustPressed = rightJustPressed = false;
        leftJustReleased = middleJustReleased = rightJustReleased = false;
    }
}