package com.company;

import com.company.SnakeGame.MainWindow;
import com.company.SnakeGame.Settings;

import static com.company.SnakeGame.Settings.*;

public class Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow(new Settings(
                DOT_SIZE,
                SNAKE_DOT_IMAGE_LOCATION,
                APPLE_IMAGE_LOCATION
        ));
    }
}
