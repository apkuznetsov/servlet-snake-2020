package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import static com.company.SnakeGame.Settings.*;

public class Field extends JPanel implements ActionListener {
    // region статика
    private static int START_X = 48;
    // endregion

    private class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent ev) {
            super.keyPressed(ev);
            int key = ev.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !snake.isMovingRight()) {
                snake.setMovingDirection(Snake.Directions.LEFT);
            } else if (key == KeyEvent.VK_RIGHT && !snake.isMovingLeft()) {
                snake.setMovingDirection(Snake.Directions.RIGHT);
            } else if (key == KeyEvent.VK_UP && !snake.isMovingDown()) {
                snake.setMovingDirection(Snake.Directions.UP);
            } else if (key == KeyEvent.VK_DOWN && !snake.isMovingUp()) {
                snake.setMovingDirection(Snake.Directions.DOWN);
            }
        }
    }

    private boolean isPlaying = true;

    private final Snake snake;
    private final Apple apple;

    public Field(
            @NotNull Image snakeDotImage,
            @NotNull Image appleImage
    ) {

        snake = new Snake(snakeDotImage, DOT_SIZE, ALL_DOTS, START_X);
        apple = new Apple(appleImage);

        this.setBorder(BorderFactory.createLineBorder(Color.white));
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());

        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new FieldKeyListener());

        initGame();
    }

    public void initGame() {
        Timer timer = new Timer(250, this);
        timer.start();

        changeAppleCoords();
    }

    public void changeAppleCoords() {
        apple.setX(new Random().nextInt(WINDOW_SIZE / DOT_SIZE) * DOT_SIZE);
        apple.setY(new Random().nextInt(WINDOW_SIZE / DOT_SIZE) * DOT_SIZE);
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        if (isPlaying) {
            gr.drawImage(apple.getImage(), apple.getX(), apple.getY(), this);

            for (int i = 0; i < snake.getSize(); i++) {
                gr.drawImage(snake.getSnakeDotImage(), snake.getX(i), snake.getY(i), this);
            }
        } else {
            String str = "Game Over";
            //Font font = new Font("Arial", 14, Font.BOLD);
            gr.setColor(Color.WHITE);
            //gr.setFont(font);
            gr.drawString(str, 120, WINDOW_SIZE / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isPlaying) {
            checkApple();
            checkCollisions();
            snake.move();
        }

        repaint();
    }

    public void checkApple() {
        if (snake.getX(0) == apple.getX() && snake.getY(0) == apple.getY()) {
            snake.incSize();
            changeAppleCoords();
        }
    }

    public void checkCollisions() {
        for (int i = snake.getSize(); i > 0; i--) {
            if (i > 4 && snake.getX(0) == snake.getX(i) && snake.getY(0) == snake.getY(i)) {
                isPlaying = false;
            }
        }

        if (snake.getX(0) > WINDOW_SIZE) {
            isPlaying = false;
        }
        if (snake.getX(0) < 0) {
            isPlaying = false;
        }
        if (snake.getY(0) > WINDOW_SIZE) {
            isPlaying = false;
        }
        if (snake.getY(0) < 0) {
            isPlaying = false;
        }
    }
}
