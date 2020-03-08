package com.company.Game.GameObjects;

import javax.swing.*;
import java.awt.*;

public final class Apple {
    private final Image image;
    private int x;
    private int y;

    public Apple(String imageLocation, int x, int y) {
        image = new ImageIcon(imageLocation).getImage();
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
