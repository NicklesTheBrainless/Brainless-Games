package base.listeners.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyBoardHandler implements KeyListener {

    private final Set<Integer> pressedKeys = new HashSet<>();
    private final Set<Integer> keyJustPressed = new HashSet<>();
    private final Set<Integer> keyJustReleased = new HashSet<>();

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (!pressedKeys.contains(keyCode)) {
            keyJustPressed.add(keyCode);
        }

        pressedKeys.add(keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (pressedKeys.contains(keyCode)) {
            keyJustReleased.add(keyCode);
        }

        pressedKeys.remove(keyCode);
    }



    public void update() {
        keyJustPressed.clear();
        keyJustReleased.clear();
    }



    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public boolean wasKeyJustPressed(int keyCode) {
        return keyJustPressed.contains(keyCode);
    }

    public boolean wasKeyJustReleased(int keyCode) {
        return keyJustReleased.contains(keyCode);
    }



    public void clearAllKeys() {
        pressedKeys.clear();
        keyJustPressed.clear();
        keyJustReleased.clear();
    }

}
