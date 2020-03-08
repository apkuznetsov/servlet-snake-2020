package com.company.Game;

import javax.swing.*;

import static com.company.Game.Settings.TITLE;
import static com.company.Game.Settings.WINDOW_SIZE;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WINDOW_SIZE, WINDOW_SIZE);
        add(new GameField());
        setVisible(true);
    }
}
