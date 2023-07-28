package game_objects;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public int updateX(Direction direction, int x, int difference) {
        if (direction == Direction.LEFT) x -= difference;
        if (direction == Direction.RIGHT) x += difference;
        return x;
    }

    public int updateY(Direction direction, int y, int difference) {
        if (direction == Direction.UP) y -= difference;
        if (direction == Direction.DOWN) y += difference;
        return y;
    }
}
