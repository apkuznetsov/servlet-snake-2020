package com.company;

import com.company.SnakeGame.MainWindow;
import com.company.SnakeGame.Settings;

import static com.company.SnakeGame.Settings.SNAKE_DOT_IMAGE_LOCATION;

public class Main {
    public static void main(String[] args) {
        MainWindow mw = new MainWindow(new Settings(SNAKE_DOT_IMAGE_LOCATION));
    }
}
