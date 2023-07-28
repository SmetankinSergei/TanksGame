package game_objects.landscape;

import game_objects.GameObject;
import window.ImageManager;
import window.panels.Stage;

import java.awt.*;

public abstract class Cell extends GameObject {

    int x;
    int y;
    int width = 20;
    int height = 20;
    static int cellWidth;
    static int cellHeight;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        cellWidth = width;
        cellHeight = height;
    }

    public static int getCellWidth() {
        return cellWidth;
    }

    public static int getCellHeight() {
        return cellHeight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
