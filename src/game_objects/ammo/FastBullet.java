package game_objects.ammo;

import game_objects.Direction;

public class FastBullet extends Bullet {

    public FastBullet(int x, int y, Direction direction) {
        super(x, y, direction);
        speed = 6;
        distance = 500;
        damage = 1;
        width = 8;
        height = 8;
    }
}
