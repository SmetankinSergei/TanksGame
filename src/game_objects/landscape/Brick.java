package game_objects.landscape;

import game_objects.Attackable;
import game_objects.Impassable;

public class Brick extends Cell implements Attackable, Impassable {

    public Brick(int x, int y) {
        super(x, y);
        strength = 2;
        maxStrength = 2;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void getDamage(int damage) {
        strength -= damage;
    }
}
