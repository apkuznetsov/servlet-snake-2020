package com.company;

import com.company.SnakeGame.Window;
import com.company.SnakeGame.Settings;

import static com.company.SnakeGame.Settings.*;

public class Main {
    public static void main(String[] args) {
        new Window(new Settings(
                DOT_SIZE,
                DOTS_NUMBER_PER_DIMENSION,
                SNAKE_DOT_IMAGE_LOCATION,
                APPLE_IMAGE_LOCATION
        ));
    }
}
