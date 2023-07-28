package game_objects.ammo;

import game_objects.Direction;

public class PowerBullet extends Bullet {

    public PowerBullet(int x, int y, Direction direction) {
        super(x, y, direction);
        speed = 3;
        distance = 300;
        damage = 3;
        width = 10;
        height = 10;
    }
}