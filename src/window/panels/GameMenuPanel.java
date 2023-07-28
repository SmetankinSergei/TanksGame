package window.panels;

import window.Controller;
import window.Window;
import window.buttons.BackToGameButtonPanel;
import window.buttons.ButtonPanel;
import window.buttons.SampleButtonPanel;
import window.buttons.TypeButton;


public class GameMenuPanel extends SamplePanel {

    public GameMenuPanel(Window window, Controller controller) {
        super(window, controller);
        setSize(500, 500);
        setLocation(200, 100);
        setVisible(false);
        SampleButtonPanel startMenuButtonPanel = new ButtonPanel(window, TypeButton.START_MENU_BUTTON);
        SampleButtonPanel exitGameButtonPanel = new ButtonPanel(window, TypeButton.EXIT_GAME_BUTTON);
        SampleButtonPanel backButtonPanel = new BackToGameButtonPanel(window, TypeButton.BACK_TO_GAME_BUTTON, this);
        addButtonPanel(startMenuButtonPanel, controller, 113, 81, 274, 46);
        addButtonPanel(exitGameButtonPanel, controller, 126, 187, 248, 46);
        addButtonPanel(backButtonPanel, controller, 191, 373, 118, 46);
    }
}
