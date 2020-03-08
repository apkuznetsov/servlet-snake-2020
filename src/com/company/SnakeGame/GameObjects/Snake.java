package com.company.SnakeGame.GameObjects;

import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.company.SnakeGame.Settings.DOT_SIZE;

public final class Snake {
    private final Image snakeDotImage;
    private final int dotSize;

    private int size;

    private final int[] xCoords;
    private final int[] yCoords;

    public Snake(
            @NotNull Image snakeDotImage,
            final int dotSize,
            final int maxSize,
            final int startX
    ) {
        this.snakeDotImage = snakeDotImage;
        this.dotSize = dotSize;

        size = 3;

        xCoords = new int[maxSize];
        yCoords = new int[xCoords.length];
        initDots(startX);
    }

    private void initDots(final int startX) {
        for (int dotIndex = 0; dotIndex < getSize(); dotIndex++) {
            xCoords[dotIndex] = startX - dotIndex * dotSize;
            yCoords[dotIndex] = startX;
        }
    }

    public Image getSnakeDotImage() {
        return snakeDotImage;
    }

    public int getSize() {
        return size;
    }

    public void incSize() {
        size++;
    }
}
