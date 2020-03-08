package com.company.SnakeGame;

import org.jetbrains.annotations.NotNull;

public final class Settings {
    // region статика
    public static final int DOT_SIZE = 16;
    public static final int DOTS_NUMBER_PER_DIMENSION = 20;

    public static final String APPLE_IMAGE_LOCATION = "apple.png";
    public static final String SNAKE_DOT_IMAGE_LOCATION = "snake-dot.png";
    // endregion

    private final int dotSize;
    private final int windowSizePerDimension;
    private final int allDotsNumber;

    private final String snakeDotImageLocation;
    private final String appleImageLocation;

    public Settings(
            final int dotSize,
            final int dotNumberPerDimension,
            @NotNull final String snakeDotImageLocation,
            @NotNull final String appleImageLocation) {

        this.dotSize = dotSize;

        windowSizePerDimension = this.dotSize * dotNumberPerDimension;
        allDotsNumber = (int) Math.pow(dotNumberPerDimension, 2);

        this.snakeDotImageLocation = snakeDotImageLocation;
        this.appleImageLocation = appleImageLocation;
    }

    public int getDotSize() {
        return dotSize;
    }

    public int getWindowSizePerDimension() {
        return windowSizePerDimension;
    }

    public int getAllDotsNumber() {
        return allDotsNumber;
    }

    public String getSnakeDotImageLocation() {
        return snakeDotImageLocation;
    }

    public String getAppleImageLocation() {
        return appleImageLocation;
    }
}
