package com.company;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class GameField extends JPanel {
    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = (int)Math.pow(SIZE/DOT_SIZE, 2);

    private Image dot;
    private Image apple;

    private int appleX;
    private int appleY;

    private int[] snakeX = new int[ALL_DOTS];
    private int[] snakeY = new int[ALL_DOTS];

    private int snakeSize;

    private Time timer;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean isInGame = true;

    public GameField() {
        setBackground(Color.black);
        loadImages();
    }

    public void loadImages() {
        ImageIcon iiApple = new ImageIcon("apple.png");
        apple = iiApple.getImage();

        ImageIcon iiDot = new ImageIcon("dot.png");
        dot = iiDot.getImage();
    }
}
