package base.listeners;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelHandler implements MouseWheelListener {

    private int wheelDelta = 0;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        wheelDelta = e.getWheelRotation();
    }



    public int getWheelDelta() {
        return wheelDelta;
    }



    public void update() {
        wheelDelta = 0;
    }
}
