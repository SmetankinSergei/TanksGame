package game_objects.ammo;

import game_objects.GameObject;
import game_objects.Direction;
import game_objects.Movable;
import window.panels.Stage;

import java.awt.*;

public abstract class Bullet extends GameObject implements Movable {

    int startX;
    int startY;
    int distance;
    int speed;
    int damage;
    Direction direction;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        startX = x;
        startY = y;
    }

    @Override
    public void move() {
        updateCoordinates(direction, this, speed);
    }

    public void update() {
        move();
        if (isDone()) setDestroyIt(true);
    }

    public boolean isDone() {
        return Math.abs(x - startX) >= distance || Math.abs(y - startY) >= distance;
    }

    public int getBulletDamage() {
        return damage;
    }

    @Override
    public void render(Graphics g, Stage stage) {
        g.setColor(Color.black);
        g.fillOval(x - width / 2, y - width / 2, width, height);
    }
}
