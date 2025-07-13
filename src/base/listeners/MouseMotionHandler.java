package base.listeners;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

    private Point mousePosition = new Point();
    private Point mouseVelocity = new Point();

    @Override
    public void mouseMoved(MouseEvent e) {

        Point newPoint = e.getPoint();
        mouseVelocity.x = newPoint.x - mousePosition.x;
        mouseVelocity.y = newPoint.y - mousePosition.y;

        mousePosition = newPoint;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        Point newPoint = e.getPoint();
        mouseVelocity.x = newPoint.x - mousePosition.x;
        mouseVelocity.y = newPoint.y - mousePosition.y;

        mousePosition = newPoint;
    }



    public Point getMousePosition() {
        return new Point(mousePosition);
    }
    public int getX() {
        return mousePosition.x;
    }
    public int getY() {
        return mousePosition.y;
    }

    public Point getMouseVelocity() {
        return new Point(mouseVelocity);
    }
    public int getVX() {
        return mouseVelocity.x;
    }
    public int getVY() {
        return mouseVelocity.y;
    }



    public void update() {
        mouseVelocity.x = 0;
        mouseVelocity.y = 0;
    }

}
