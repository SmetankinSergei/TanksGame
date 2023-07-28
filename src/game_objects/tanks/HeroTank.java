package game_objects.tanks;

import game_objects.ammo.*;
import game_objects.Direction;
import window.panels.Stage;
import window.panels.TypeMoveControl;

import java.awt.event.KeyEvent;

public class HeroTank extends Tank {

    private final TypeMoveControl typeMoveControl;
    private final TypeTank typeTank;

    public HeroTank(Stage stage, TypeMoveControl typeMoveControl, TypeTank typeTank, int x, int y) {
        super(stage, typeTank, x, y);
        this.typeMoveControl = typeMoveControl;
        this.typeTank = typeTank;
        setCharacteristics(typeTank);
    }

    private void setCharacteristics(TypeTank typeTank) {
        if (typeTank == TypeTank.SIMPLE) {
            simpleBulletsAmount = 100;
            fastBulletsAmount = 100;
            powerBulletsAmount = 0;
            maxSimpleBulletsAmount = 100;
            maxFastBulletsAmount = 100;
            maxPowerBulletsAmount = 100;
            clipVolume = 10;
            reloadClipDelay = 1000;
            reloadBulletDelay = 2000;
            speed = 1;
            strength = 10;
            maxStrength = 10;
        } else if (typeTank == TypeTank.FAST) {
            simpleBulletsAmount = 100;
            fastBulletsAmount = 100;
            powerBulletsAmount = 0;
            maxSimpleBulletsAmount = 100;
            maxFastBulletsAmount = 100;
            maxPowerBulletsAmount = 100;
            clipVolume = 10;
            reloadClipDelay = 1000;
            reloadBulletDelay = 2000;
            speed = 2;
            strength = 8;
            maxStrength = 8;
        } else if (typeTank == TypeTank.POWER) {
            simpleBulletsAmount = 100;
            fastBulletsAmount = 0;
            powerBulletsAmount = 100;
            maxSimpleBulletsAmount = 100;
            maxFastBulletsAmount = 100;
            maxPowerBulletsAmount = 100;
            clipVolume = 10;
            reloadClipDelay = 1000;
            reloadBulletDelay = 2000;
            speed = 1;
            strength = 15;
            maxStrength = 15;
        } else if (typeTank == TypeTank.SUPER) {
            simpleBulletsAmount = 100;
            fastBulletsAmount = 100;
            powerBulletsAmount = 100;
            maxSimpleBulletsAmount = 100;
            maxFastBulletsAmount = 100;
            maxPowerBulletsAmount = 100;
            clipVolume = 10;
            reloadClipDelay = 1000;
            reloadBulletDelay = 2000;
            speed = 2;
            strength = 15;
            maxStrength = 15;
        }
    }

    @Override
    public void addAmmo(TypeBullet type) {
        if (ammo > 0) return;
        if (type == TypeBullet.SIMPLE) {
            typeBullet = TypeBullet.SIMPLE;
            ammo = Math.min(simpleBulletsAmount, clipVolume);
            simpleBulletsAmount -= ammo;
        } else
        if (type == TypeBullet.FAST) {
            if (type == TypeBullet.POWER) return;
            typeBullet = TypeBullet.FAST;
            ammo = Math.min(fastBulletsAmount, clipVolume);
            fastBulletsAmount -= ammo;
        } else
        if (type == TypeBullet.POWER) {
            if (typeTank == TypeTank.SIMPLE && typeTank == TypeTank.FAST) return;
            typeBullet = TypeBullet.POWER;
            ammo = Math.min(powerBulletsAmount, clipVolume);
            powerBulletsAmount -= ammo;
        } else {
            throw new RuntimeException("From addAmmo in HeroTank: unknown bullet type: " + type);
        }
        isReloaded = false;
        startTimeReloadDelay = System.currentTimeMillis(); // нужно для отрисовки
        reloadDelay(reloadClipDelay, isReloaded);
    }

    public TypeTank getTypeTank() {
        return typeTank;
    }

    @Override
    public void update(int key) {
        if (typeMoveControl == TypeMoveControl.LETTERS_CONTROL) {
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_S || key == KeyEvent.VK_A || key == KeyEvent.VK_D)
                isStop = false;
            if (key == KeyEvent.VK_W) direction = Direction.UP;
            else if (key == KeyEvent.VK_S) direction = Direction.DOWN;
            else if (key == KeyEvent.VK_A) direction = Direction.LEFT;
            else if (key == KeyEvent.VK_D) direction = Direction.RIGHT;
            else if (key == KeyEvent.VK_C) isStop = true;
            else if (key == KeyEvent.VK_X && isReady) new Thread(() -> shoot(direction)).start();
            else if (key == KeyEvent.VK_1 && ammo == 0 && simpleBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.SIMPLE)).start();
            else if (key == KeyEvent.VK_2 && ammo == 0 && fastBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.FAST)).start();
            else if (key == KeyEvent.VK_3 && ammo == 0 && powerBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.POWER)).start();
        } else if (typeMoveControl == TypeMoveControl.ARROWS_CONTROL) {
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
                isStop = false;
            if (key == KeyEvent.VK_UP) direction = Direction.UP;
            else if (key == KeyEvent.VK_DOWN) direction = Direction.DOWN;
            else if (key == KeyEvent.VK_LEFT) direction = Direction.LEFT;
            else if (key == KeyEvent.VK_RIGHT) direction = Direction.RIGHT;
            else if (key == KeyEvent.VK_F) isStop = true;
            else if (key == KeyEvent.VK_D && isReady) new Thread(() -> shoot(direction)).start();
            else if (key == KeyEvent.VK_Q && ammo == 0 && simpleBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.SIMPLE)).start();
            else if (key == KeyEvent.VK_W && ammo == 0 && fastBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.FAST)).start();
            else if (key == KeyEvent.VK_E && ammo == 0 && powerBulletsAmount > 0)
                new Thread(() -> addAmmo(TypeBullet.POWER)).start();
        }

        move();
    }
}
