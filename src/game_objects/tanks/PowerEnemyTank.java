package game_objects.tanks;

import game_objects.ammo.TypeBullet;
import window.panels.Stage;

public class PowerEnemyTank extends EnemyTank {
    public PowerEnemyTank(Stage stage, int x, int y) {
        super(stage, x, y);
        speed = 1;
        strength = 15;
        maxStrength = 15;
        clipVolume = 10;
        simpleBulletsAmount = 100;
        reloadClipDelay = 4000;
        reloadBulletDelay = 1000;
        typeBullet = TypeBullet.POWER;
    }
}
