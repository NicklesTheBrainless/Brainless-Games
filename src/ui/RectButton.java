package ui;

import base.listeners.mouse.MouseButtonHandler;
import base.listeners.mouse.MouseMotionHandler;
import utils.objects.ProgramObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class RectButton extends Rectangle implements ProgramObject {

    MouseButtonHandler mouseButtonH;
    MouseMotionHandler mouseMotionH;

    BufferedImage image;

    MouseInteractionType leftInteractionType;    Runnable onLeftInteraction;
    MouseInteractionType middleInteractionType;  Runnable onMiddleInteraction;
    MouseInteractionType rightInteractionType;   Runnable onRightInteraction;

    public RectButton(MouseButtonHandler mouseButtonH, MouseMotionHandler mouseMotionH,
                      int x, int y, int width, int height, BufferedImage image,
                      MouseInteractionType leftInteractionType, Runnable onLeftInteraction,
                      MouseInteractionType middleInteractionType, Runnable onMiddleInteraction,
                      MouseInteractionType rightInteractionType, Runnable onRightInteraction) {

        super(x, y, width, height);
        this.mouseButtonH = mouseButtonH;
        this.mouseMotionH = mouseMotionH;
        this.image = image;

        this.leftInteractionType = leftInteractionType;     this.onLeftInteraction = onLeftInteraction;
        this.middleInteractionType = middleInteractionType; this.onMiddleInteraction = onMiddleInteraction;
        this.rightInteractionType = rightInteractionType;   this.onRightInteraction = onRightInteraction;
    }

    public RectButton(MouseButtonHandler mouseButtonH, MouseMotionHandler mouseMotionH,
                      int x, int y, int width, int height, BufferedImage image, Runnable onClicked) {

        super(x, y, width, height);
        this.mouseButtonH = mouseButtonH;
        this.mouseMotionH = mouseMotionH;
        this.image = image;

        this.leftInteractionType = MouseInteractionType.CLICKED;
        this.onLeftInteraction = onClicked;
    }



    @Override
    public void update() {

        Point mousePos = mouseMotionH.getMousePosition();

        if (this.contains(mousePos)) {

            // left button interaction
            if (leftInteractionType == MouseInteractionType.CLICKED && mouseButtonH.leftJustClicked) {
                onLeftInteraction.run();
            } else if (leftInteractionType == MouseInteractionType.PRESSED && mouseButtonH.leftJustPressed) {
                onLeftInteraction.run();
            } else if (leftInteractionType == MouseInteractionType.RELEASED && mouseButtonH.leftJustReleased) {
                onLeftInteraction.run();
            }

            // middle button interaction
            if (middleInteractionType == MouseInteractionType.CLICKED && mouseButtonH.middleJustClicked) {
                onMiddleInteraction.run();
            } else if (middleInteractionType == MouseInteractionType.PRESSED && mouseButtonH.middleJustPressed) {
                onMiddleInteraction.run();
            } else if (middleInteractionType == MouseInteractionType.RELEASED && mouseButtonH.middleJustReleased) {
                onMiddleInteraction.run();
            }

            // right button interaction
            if (rightInteractionType == MouseInteractionType.CLICKED && mouseButtonH.rightJustClicked) {
                onRightInteraction.run();
            } else if (rightInteractionType == MouseInteractionType.PRESSED && mouseButtonH.rightJustPressed) {
                onRightInteraction.run();
            } else if (rightInteractionType == MouseInteractionType.RELEASED && mouseButtonH.rightJustReleased) {
                onRightInteraction.run();
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        if (image != null) {
            g2.drawImage(image, x, y, width, height, null);
        } else {
            g2.setColor(Color.GRAY);
            g2.fill(this);
        }

        g2.setColor(Color.WHITE);
        if (this.contains(mouseMotionH.getMousePosition()))
            g2.setStroke(new BasicStroke(4));
        g2.draw(this);
    }

}