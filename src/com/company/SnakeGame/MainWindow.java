package com.company.SnakeGame;

import com.company.SnakeGame.GameObjects.GameField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static com.company.SnakeGame.Settings.TITLE;
import static com.company.SnakeGame.Settings.WINDOW_SIZE;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WINDOW_SIZE, WINDOW_SIZE);
        add(new GameField());
        setVisible(true);
    }
}
