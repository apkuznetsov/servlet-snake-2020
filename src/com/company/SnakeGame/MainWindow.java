package com.company.SnakeGame;

import com.company.SnakeGame.GameObjects.GameField;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import static com.company.SnakeGame.Settings.*;

public final class MainWindow extends JFrame {
    public MainWindow(@NotNull final Settings settings) {
        setTitle(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(WINDOW_SIZE, WINDOW_SIZE);
        add(new GameField(new ImageIcon(settings.getSnakeDotImageLocation()).getImage()));
        setVisible(true);
    }
}
