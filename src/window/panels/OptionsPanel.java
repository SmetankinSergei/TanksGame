package window.panels;

import window.Controller;
import window.ImageManager;
import window.Window;
import window.buttons.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsPanel extends SamplePanel implements RadioOwner {

    private final RadioButtonPanel lettersControlRadioButton;
    private final RadioButtonPanel arrowsControlRadioButton;

    private final MarkPanel lettersMarkPanel = new MarkPanel();
    private final MarkPanel arrowsMarkPanel = new MarkPanel();
    private final BufferedImage optionOkImg = ImageManager.getSimpleOkImg();
    private final BufferedImage optionNoImg = ImageManager.getSimpleNoImg();
    private final List<RadioButtonPanel> radioButtonsList;

    public OptionsPanel(Window window, Controller controller) {
        super(window, controller);
        setBackground(Color.darkGray);
        SampleButtonPanel exitButtonPanel = new ButtonPanel(window, TypeButton.BACK_BUTTON);
        lettersControlRadioButton = new RadioButtonPanel(window, TypeButton.MOVE_OPTIONS_RADIO_BUTTON, this, true);
        arrowsControlRadioButton = new RadioButtonPanel(window, TypeButton.MOVE_OPTIONS_RADIO_BUTTON, this, false);
        radioButtonsList = createRadioButtonGroup(lettersControlRadioButton, arrowsControlRadioButton);
        addButtonPanel(exitButtonPanel, controller, 642, 657, 118, 46);
        addButtonPanel(lettersControlRadioButton, controller, 140, 109, 40, 46);
        addButtonPanel(arrowsControlRadioButton, controller, 720, 109, 40, 46);
        addMarkPanel(lettersMarkPanel, 140, 591, 40, 46);
        addMarkPanel(arrowsMarkPanel, 140, 657, 40, 46);
        lettersMarkPanel.setImage(optionOkImg);
        arrowsMarkPanel.setImage(optionNoImg);
    }

    @Override
    public void updRadioButtonsGroup() {
        for (RadioButtonPanel panel : radioButtonsList) {
            if (panel.isClicked() && !panel.isActive()) {
                panel.setActive(true);
                panel.setClicked(false);
                updMarkPanels();
                if (panel == lettersControlRadioButton) window.setTypeMoveControl(TypeMoveControl.LETTERS_CONTROL);
                if (panel == arrowsControlRadioButton) window.setTypeMoveControl(TypeMoveControl.ARROWS_CONTROL);
            } else {
                panel.setActive(false);
                panel.repaint();
            }
        }
    }

    @Override
    public List<RadioButtonPanel> createRadioButtonGroup(RadioButtonPanel... panels) {
        return new ArrayList<>(Arrays.asList(panels));
    }

    private void updMarkPanels() {
        if (lettersControlRadioButton.isActive()) {
            lettersMarkPanel.setImage(optionOkImg);
            arrowsMarkPanel.setImage(optionNoImg);
            lettersMarkPanel.repaint();
            arrowsMarkPanel.repaint();
        } else if (arrowsControlRadioButton.isActive()) {
            arrowsMarkPanel.setImage(optionOkImg);
            lettersMarkPanel.setImage(optionNoImg);
            lettersMarkPanel.repaint();
            arrowsMarkPanel.repaint();
        }
    }
}
