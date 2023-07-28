package game_objects.tanks;

import game_objects.ammo.TypeBullet;
import game_objects.Direction;
import window.panels.Stage;

import java.util.Random;

public abstract class EnemyTank extends Tank {

    Direction direction = Direction.LEFT;
    Random random = new Random();

    public EnemyTank(Stage stage, int x, int y) {
        super(stage, TypeTank.SIMPLE, x, y);
    }

    @Override
    public void update(int key) {
        if (isStop) {
            setNewDirection(key);
            isStop = false;
            isCollision = false;
        } else {
            move();
            tryToShoot();
        }
    }

    @Override
    void addAmmo(TypeBullet type) {
        if (ammo == 0 && simpleBulletsAmount > 0 && isReady) {
            isReloaded = false;
            ammo = Math.min(simpleBulletsAmount, clipVolume);
            simpleBulletsAmount -= ammo;
            reloadDelay(reloadClipDelay, isReloaded);
        }
    }

    private void tryToShoot() {
        if (ammo == 0 && isReloaded) new Thread(() -> addAmmo(TypeBullet.SIMPLE)).start();
        if (ammo > 0) new Thread(() -> shoot(direction)).start();
    }

    private void setNewDirection(int key) {
        Direction wrongDirection = direction;
        int d = random.nextInt(4);
        if (d == 0) direction = Direction.UP;
        if (d == 1) direction = Direction.DOWN;
        if (d == 2) direction = Direction.LEFT;
        if (d == 3) direction = Direction.RIGHT;
        if (direction == wrongDirection) update(key);
    }
}
