package com.company.SnakeGame;

import com.company.SnakeGame.GameObjects.Board;

import javax.swing.*;
import java.awt.*;

public final class Window extends JFrame {
    public Window(final Settings settings) {
        super("Змейка");

        getContentPane().add(new Board(settings));
        pack();

        setWindow();
    }

    private void setWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationInCenter();
        setVisible(true);
    }

    private void setLocationInCenter() {
        setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                screenSize.width / 2 - this.getSize().width / 2,
                screenSize.height / 2 - this.getSize().height / 2);
    }
}
