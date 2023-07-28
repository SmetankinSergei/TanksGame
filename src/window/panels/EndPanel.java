package window.panels;

import window.Controller;
import window.Window;
import window.buttons.ButtonPanel;
import window.buttons.SampleButtonPanel;
import window.buttons.TypeButton;

import java.awt.*;

public class EndPanel extends SamplePanel {

    public EndPanel(Window window, Controller controller) {
        super(window, controller);
        setBackground(Color.darkGray);
        SampleButtonPanel startMenuButtonPanel = new ButtonPanel(window, TypeButton.START_MENU_BUTTON);
        SampleButtonPanel exitGameButtonPanel = new ButtonPanel(window, TypeButton.EXIT_GAME_BUTTON);
        addButtonPanel(startMenuButtonPanel, controller, 313, 568, 274, 46);
        addButtonPanel(exitGameButtonPanel, controller, 326, 688, 248, 46);
    }
}
