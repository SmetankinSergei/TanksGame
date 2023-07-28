package window.panels;

import window.Controller;
import window.Window;
import window.buttons.ButtonPanel;
import window.buttons.SampleButtonPanel;
import window.buttons.TypeButton;

import java.awt.*;

public class StartMenuPanel extends SamplePanel {

    public StartMenuPanel(Window window, Controller controller) {
        super(window, controller);
        SampleButtonPanel startButtonPanel = new ButtonPanel(window, TypeButton.START_BUTTON);
        SampleButtonPanel optionsButtonPanel = new ButtonPanel(window, TypeButton.OPTIONS_BUTTON);
        SampleButtonPanel exitButtonPanel = new ButtonPanel(window, TypeButton.EXIT_BUTTON);
        setBackground(Color.darkGray);
        addButtonPanel(startButtonPanel, controller, 131, 694, 190, 50);
        addButtonPanel(optionsButtonPanel, controller,  355, 694, 190, 50);
        addButtonPanel(exitButtonPanel, controller, 577, 694, 190, 50);
    }
}
