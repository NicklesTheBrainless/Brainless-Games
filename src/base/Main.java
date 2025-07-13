package base;

import base.panel.ProgramPanel;

import javax.swing.*;

import static base.setting.Settings.TITLE;

public class Main {

    public static void main(String[] args) {

        // create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set title and if it is resizable
        window.setTitle(TITLE);
        window.setResizable(false);

        // create the GamePanel and add it to the window
        ProgramPanel panel = new ProgramPanel();
        window.add(panel);
        window.pack();

        //////////////////////////
        // set window icon here //
        //////////////////////////

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // start game
        panel.startProgramThread();
    }
}