package game_objects.ammo;

import game_objects.Direction;

public class SimpleBullet extends Bullet {

    public SimpleBullet(int x, int y, Direction direction) {
        super(x, y, direction);
        speed = 4;
        distance = 400;
        damage = 1;
        width = 8;
        height = 8;
    }
}
