package game_objects.ammo;

import game_objects.Direction;

public class PowerBulletForSuperTank extends PowerBullet {
    public PowerBulletForSuperTank(int x, int y, Direction direction) {
        super(x, y, direction);
        width = 8;
        height = 8;
    }
}
