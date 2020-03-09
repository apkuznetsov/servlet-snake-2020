package com.company.SnakeGame;

import com.company.SnakeGame.GameObjects.Field;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public final class Window extends JFrame {
    public Window(@NotNull final Settings settings) {
        setTitle("Змейка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setSize(settings.getWindowSizePerDimension(), settings.getWindowSizePerDimension());
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
        setResizable(false);

        add(new Field(settings), BorderLayout.CENTER);

        setVisible(true);
    }
}
