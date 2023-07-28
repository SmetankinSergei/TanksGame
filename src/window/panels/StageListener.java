package window.panels;

import game_objects.GameObject;

import java.awt.*;
import java.util.List;

public interface StageListener {

    void render(Graphics g, List<GameObject> field, List<GameObject> bullets,
                List<GameObject> tanks, List<GameObject> flags);
    void update(List<GameObject> bullets, List<GameObject> field,
                List<GameObject> tanks, List<GameObject> flags);
}
