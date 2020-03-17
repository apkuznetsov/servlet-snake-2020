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

public class Board extends JPanel implements ActionListener {
    private final int dotSize;

    private final Random random;
    private final Apple apple;

    private Timer timer;
    private boolean isPlaying;
    private Snake snake;

    public Board(@NotNull final Settings settings) {
        dotSize = settings.getDotSize();

        setSize(new Dimension(settings.getWindowSizePerDimension(), settings.getWindowSizePerDimension()));
        setPreferredSize(getSize());
        setBackground(Color.black);

        addKeyListener(new FieldKeyListener());

        timer = new Timer(100, this);
        isPlaying = true;

        snake = new Snake(
                new ImageIcon(settings.getSnakeDotImageLocation()).getImage(),
                this.dotSize, settings.getAllDotsNumber(),
                this.getWidth() / 2);

        apple = new Apple(new ImageIcon(settings.getAppleImageLocation()).getImage());
        random = new Random();

        setVisible(true);
        setFocusable(true);

        startGame();
    }

    private void startGame() {
        timer.start();
        randomAppleCoords();
    }

    private void restartGame() {
        isPlaying = true;
        timer.start();

        snake = new Snake(
                snake.getSnakeDotImage(),
                this.dotSize,
                snake.getMaxDotsNumber(),
                this.getWidth() / 2);

        randomAppleCoords();
    }

    private void randomAppleCoords() {
        apple.setX(random.nextInt(this.getWidth() / dotSize) * dotSize);
        apple.setY(random.nextInt(this.getHeight() / dotSize) * dotSize);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (isPlaying
                && !isBadCollision()) {

            if (isAppleCollision()) {
                snake.incSize();
                randomAppleCoords();
            }

            snake.move();
        }

        repaint();
    }

    private boolean isBadCollision() {
        return isSnakeCollision() || isBorderCollision();
    }

    private boolean isSnakeCollision() {
        for (int i = snake.getSize(); i > 0; i--) {
            if (i > 4
                    && snake.getX(0) == snake.getX(i)
                    && snake.getY(0) == snake.getY(i)) {

                isPlaying = false;
                return true;
            }
        }

        return false;
    }

    private boolean isBorderCollision() {
        if (snake.getX(0) >= this.getWidth()
                || snake.getX(0) < 0
                || snake.getY(0) >= this.getHeight()
                || snake.getY(0) < 0) {

            isPlaying = false;
            return true;
        }

        return false;
    }

    private boolean isAppleCollision() {
        return snake.getX(0) == apple.getX()
                && snake.getY(0) == apple.getY();
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        if (isPlaying) {
            drawSnake(gr);
            drawApple(gr);
        } else {
            timer.stop();
            drawGameOver(gr);
        }
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
        gr.drawString("Игра окончена. Нажмите ENTER, чтобы сыграть ещё", this.getWidth() / 2, this.getHeight() / 2);
    }

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
            } else if (key == KeyEvent.VK_ENTER && !isPlaying) {
                restartGame();
            }
        }
    }
}
