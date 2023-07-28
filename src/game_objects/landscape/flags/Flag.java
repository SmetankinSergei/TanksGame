package game_objects.landscape.flags;

import game_objects.landscape.Cell;
import window.panels.Stage;

public abstract class Flag extends Cell {

    private final Stage stage;
    private boolean isCaptured;
    private int flagWidth = 36;
    private int getFlagHeight = 36;

    public Flag(int x, int y, Stage stage) {
        super(x, y);
        this.stage = stage;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public int getWidth() {
        return flagWidth;
    }

    public int getHeight() {
        return getFlagHeight;
    }
}
