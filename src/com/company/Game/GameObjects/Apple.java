package com.company.Game.GameObjects;

import javax.swing.*;
import java.awt.*;

public final class Apple {
    private final Image image;
    private int x;
    private int y;

    public Apple(Image image) {
        this.image = image;
        x = 0;
        y = 0;
    }

    public Apple(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this. y= y;
    }
}
