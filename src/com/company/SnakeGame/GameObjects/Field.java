package com.company.SnakeGame.GameObjects;

import com.company.SnakeGame.Settings;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Field extends JPanel implements ActionListener {
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

    private final int dotSize;

    private final Snake snake;
    private final Apple apple;
    private final Random random;

    public Field(@NotNull Settings settings) {
        setSize(settings.getWindowSizePerDimension(), settings.getWindowSizePerDimension());

        this.dotSize = settings.getDotSize();

        snake = new Snake(
                new ImageIcon(settings.getSnakeDotImageLocation()).getImage(),
                this.dotSize, settings.getAllDotsNumber(),
                this.getWidth() / 2);
        apple = new Apple(new ImageIcon(settings.getAppleImageLocation()).getImage());
        random = new Random();

        this.setBorder(BorderFactory.createLineBorder(Color.white));

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

    private void randomAppleCoords() {
        apple.setX(random.nextInt(this.getWidth() / dotSize) * dotSize);
        apple.setY(random.nextInt(this.getHeight() / dotSize) * dotSize);
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
            gr.drawString(str, 120, this.getWidth() / 2);
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

        if (snake.getX(0) > this.getWidth()) {
            isPlaying = false;
        }
        if (snake.getX(0) < 0) {
            isPlaying = false;
        }

    private void drawSnake(Graphics gr) {
        for (int snakeDot = 0; snakeDot < snake.getSize(); snakeDot++) {
            gr.drawImage(snake.getSnakeDotImage(), snake.getX(snakeDot), snake.getY(snakeDot), this);
        }
    }

    private void drawApple(Graphics gr) {
        gr.drawImage(apple.getImage(), apple.getX(), apple.getY(), this);
    }

    private void drawGameOver(Graphics gr) {
        gr.setColor(Color.WHITE);
        gr.drawString("Игра окончена", this.getWidth() / 2, this.getHeight() / 2);
    }
}
