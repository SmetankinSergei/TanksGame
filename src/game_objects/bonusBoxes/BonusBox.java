package game_objects.bonusBoxes;

import game_objects.GameObject;
import window.ImageManager;
import window.panels.Stage;

import java.awt.*;

public abstract class BonusBox extends GameObject {

    int x;
    int y;
    int width = 36;
    int height = 36;
    int amount;
    Color color;

    public BonusBox(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
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

    @Override
    public void render(Graphics g, Stage stage) {
        if (this instanceof BigHealthBox) g.drawImage(ImageManager.getBigHealthBoxImg(), getX(), getY(), stage);
        if (this instanceof SmallHealthBox) g.drawImage(ImageManager.getSmallHealthBoxImg(), getX(), getY(), stage);

        if (this instanceof SimpleBulletBox) g.drawImage(ImageManager.getSimpleBulletBoxImg(), getX(), getY(), stage);
        if (this instanceof FastBulletBox) g.drawImage(ImageManager.getFastBulletBoxImg(), getX(), getY(), stage);
        if (this instanceof PowerBulletBox) g.drawImage(ImageManager.getPowerBulletBoxImg(), getX(), getY(), stage);
    }
}
