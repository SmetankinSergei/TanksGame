package game_objects;

import game_objects.landscape.flags.EnemyFlag;
import game_objects.landscape.flags.HeroFlag;
import game_objects.landscape.Brick;
import game_objects.landscape.Indestructible;
import game_objects.landscape.River;
import window.ImageManager;
import window.panels.Stage;

import java.awt.*;

public abstract class GameObject {

    public int x;
    public int y;
    public int width;
    public int height;
    public int strength;
    public int maxStrength;
    public boolean destroyIt;

    public void updateCoordinates(Direction direction, GameObject object, int speed) {
        object.x = direction.updateX(direction, object.getX(), speed);
        object.y = direction.updateY(direction, object.getY(), speed);
    }

    public void setDestroyIt(boolean destroyIt) {
        this.destroyIt = destroyIt;
    }

    public boolean getDestroyIt() {
        return destroyIt;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public void render(Graphics g, Stage stage) {
        if (this instanceof River) g.drawImage(ImageManager.getWaterImg(), getX(), getY(), stage);
        if (this instanceof Brick && this.getStrength() == this.getMaxStrength())
            g.drawImage(ImageManager.getBrickImg(), getX(), getY(), stage);
        if (this instanceof Brick && this.getStrength() < this.getMaxStrength())
            g.drawImage(ImageManager.getDamagedBrickImg(), getX(), getY(), stage);
        if (this instanceof Indestructible) g.drawImage(ImageManager.getIndestructibleImg(), getX(), getY(), stage);
        if (this instanceof HeroFlag) g.drawImage(ImageManager.getGreenFlagImg(), getX(), getY(), stage);
        if (this instanceof EnemyFlag) g.drawImage(ImageManager.getRedFlagImg(), getX(), getY(), stage);
    }
}
