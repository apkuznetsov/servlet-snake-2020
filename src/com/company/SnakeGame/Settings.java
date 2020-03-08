package com.company.SnakeGame;

import org.jetbrains.annotations.NotNull;

public final class Settings {
    // region статика
    public static final String TITLE = "Змейка";

    public static final int DOT_SIZE = 16;
    public static final int DOTS_NUMBER_PER_DIMENSION = 20;
    public static final int WINDOW_SIZE = DOT_SIZE * DOTS_NUMBER_PER_DIMENSION;
    public static final int ALL_DOTS = (int) Math.pow(DOTS_NUMBER_PER_DIMENSION, 2);

    public static final String APPLE_IMAGE_LOCATION = "apple.png";
    public static final String SNAKE_DOT_IMAGE_LOCATION = "snake-dot.png";
    // endregion

    public Settings() {
    }
}
