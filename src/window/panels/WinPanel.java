package window.panels;

import game_objects.tanks.TypeTank;
import window.Controller;
import window.ImageManager;
import window.ScreenState;
import window.Window;
import window.buttons.*;
import window.panels.MarkPanel;
import window.panels.SamplePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinPanel extends SamplePanel implements RadioOwner {

    Window window;
    ScreenState state;
    Controller controller;
    private List<RadioButtonPanel> radioButtonsList;
    private final RadioButtonPanel simple_tank;
    private final RadioButtonPanel fast_tank;
    private RadioButtonPanel power_tank;
    private RadioButtonPanel super_tank;

    public WinPanel(Window window, Controller controller, ScreenState state) {
        super(window, controller);
        this.window = window;
        this.state = state;
        this.controller = controller;
        setBackground(Color.darkGray);
        setLayout(null);
        SampleButtonPanel exitButtonPanel = new ButtonPanel(window, TypeButton.EXIT_GAME_BUTTON);
        addButtonPanel(exitButtonPanel, controller, 326, 642, 248, 46);

        SampleButtonPanel stage_one_button = new ButtonPanel(window, TypeButton.START_STAGE_1);
        addButtonPanel(stage_one_button, controller, 301, 355, 50, 52);
        SampleButtonPanel stage_two_button = new ButtonPanel(window, TypeButton.START_STAGE_2);
        addButtonPanel(stage_two_button, controller, 301, 421, 50, 52);
        simple_tank = new RadioButtonPanel(window, TypeButton.SIMPLE_HERO_TANK, this, true);
        addButtonPanel(simple_tank, controller, 562, 355, 50, 52);
        fast_tank = new RadioButtonPanel(window, TypeButton.FAST_HERO_TANK, this, false);
        addButtonPanel(fast_tank, controller, 562,421, 50, 52);

        setLocks(state);
        setButtons(state);
    }

    private void setLocks(ScreenState state) {
        if (state == ScreenState.HERO_WIN_STAGE_ONE) {
            MarkPanel stage_3_lock = new MarkPanel();
            addMarkPanel(stage_3_lock, 301, 487, 50, 52);
            stage_3_lock.setImage(ImageManager.getLockImg());
            MarkPanel stage_4_lock = new MarkPanel();
            addMarkPanel(stage_4_lock, 301, 553, 50, 52);
            stage_4_lock.setImage(ImageManager.getLockImg());
            MarkPanel power_tank_lock = new MarkPanel();
            addMarkPanel(power_tank_lock, 562, 487, 50, 52);
            power_tank_lock.setImage(ImageManager.getLockImg());
            MarkPanel super_tank_lock = new MarkPanel();
            addMarkPanel(super_tank_lock, 562, 553, 50, 52);
            super_tank_lock.setImage(ImageManager.getLockImg());
        } else if (state == ScreenState.HERO_WIN_STAGE_TWO) {
            MarkPanel stage_4_lock = new MarkPanel();
            addMarkPanel(stage_4_lock, 301, 553, 50, 52);
            stage_4_lock.setImage(ImageManager.getLockImg());
            MarkPanel super_tank_lock = new MarkPanel();
            addMarkPanel(super_tank_lock, 562, 553, 50, 52);
            super_tank_lock.setImage(ImageManager.getLockImg());
        }
    }

    private void setButtons(ScreenState state) {
        if (state == ScreenState.HERO_WIN_STAGE_ONE) {
            radioButtonsList = createRadioButtonGroup(simple_tank, fast_tank);
        } else if (state == ScreenState.HERO_WIN_STAGE_TWO) {
            SampleButtonPanel stage_three_button = new ButtonPanel(window, TypeButton.START_STAGE_3);
            addButtonPanel(stage_three_button, controller, 301, 487, 50, 52);
            power_tank = new RadioButtonPanel(window, TypeButton.POWER_HERO_TANK, this, false);
            addButtonPanel(power_tank, controller, 562, 487, 50, 52);
            radioButtonsList = createRadioButtonGroup(simple_tank, fast_tank, power_tank);
        } else if (state == ScreenState.HERO_WIN_STAGE_THREE) {
            SampleButtonPanel stage_three_button = new ButtonPanel(window, TypeButton.START_STAGE_3);
            addButtonPanel(stage_three_button, controller, 301, 487, 50, 52);
            SampleButtonPanel stage_four_button = new ButtonPanel(window, TypeButton.START_STAGE_4);
            addButtonPanel(stage_four_button, controller, 301, 553, 50, 52);
            power_tank = new RadioButtonPanel(window, TypeButton.POWER_HERO_TANK, this, false);
            addButtonPanel(power_tank, controller, 562, 487, 50, 52);
            super_tank = new RadioButtonPanel(window, TypeButton.SUPER_HERO_TANK, this, false);
            addButtonPanel(super_tank, controller, 562,553, 50, 52);
            radioButtonsList = createRadioButtonGroup(simple_tank, fast_tank, power_tank, super_tank);
        }
    }

    @Override
    public void updRadioButtonsGroup() {
        for (RadioButtonPanel panel : radioButtonsList) {
            if (panel.isClicked() && !panel.isActive()) {
                panel.setActive(true);
                panel.setClicked(false);
                if (panel == simple_tank) controller.setTypeTank(TypeTank.SIMPLE);
                if (panel == fast_tank) controller.setTypeTank(TypeTank.FAST);
                if (panel == power_tank) controller.setTypeTank(TypeTank.POWER);
                if (panel == super_tank) controller.setTypeTank(TypeTank.SUPER);
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
}
