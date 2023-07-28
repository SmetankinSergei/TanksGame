package window.buttons;

import window.panels.TypeMoveControl;

import java.util.List;

public interface RadioOwner {

    void updRadioButtonsGroup();
    List<RadioButtonPanel> createRadioButtonGroup(RadioButtonPanel ... panels);
}
