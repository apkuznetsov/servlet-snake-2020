package com.company.SnakeGame;

import com.company.SnakeGame.GameObjects.Field;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class Window extends JFrame {
    public Window(@NotNull final Settings settings) {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(settings.getWindowSizePerDimension(), settings.getWindowSizePerDimension());
        setResizable(false);

        add(new Field(settings));

        setVisible(true);
    }
}
