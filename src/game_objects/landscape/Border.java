package game_objects.landscape;

import game_objects.Impassable;

public class Border extends Cell implements Impassable {

    public Border(int x, int y) {
        super(x, y);
    }
}
