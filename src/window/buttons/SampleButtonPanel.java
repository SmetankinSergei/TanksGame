package window.buttons;

import window.Controller;
import window.ScreenState;
import window.Window;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SampleButtonPanel extends JPanel implements MouseListener {

    Window window;
    ButtonPanelState state;
    TypeButton typeButton;
    Controller controller;

    public SampleButtonPanel(Window window, TypeButton typeButton, ButtonPanelState state) {
        this.window = window;
        this.typeButton = typeButton;
        this.state = state;
        addMouseListener(this);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        state = ButtonPanelState.PRESSED;
        repaint();
    }

    boolean checkCoordinates(MouseEvent e) {
        return e.getX() >= 0 && e.getX() <= getWidth() && e.getY() >= 0 && e.getY() <= getHeight();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (checkCoordinates(e) && (typeButton == TypeButton.START_BUTTON ||
            typeButton == TypeButton.START_STAGE_1)) controller.updState(ScreenState.STAGE_1);
        if (checkCoordinates(e) && typeButton == TypeButton.START_STAGE_2) controller.updState(ScreenState.STAGE_2);
        if (checkCoordinates(e) && typeButton == TypeButton.START_STAGE_3) controller.updState(ScreenState.STAGE_3);
        if (checkCoordinates(e) && typeButton == TypeButton.START_STAGE_4) controller.updState(ScreenState.STAGE_4);
        if (checkCoordinates(e) && typeButton == TypeButton.OPTIONS_BUTTON) controller.updState(ScreenState.OPTIONS);
        if (checkCoordinates(e) && typeButton == TypeButton.BACK_BUTTON) controller.updState(ScreenState.START);
        if (checkCoordinates(e) && typeButton == TypeButton.EXIT_GAME_BUTTON) System.exit(0);
        if (checkCoordinates(e) && typeButton == TypeButton.START_MENU_BUTTON) controller.updState(ScreenState.START);
        if (checkCoordinates(e) && typeButton == TypeButton.EXIT_BUTTON) System.exit(0);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        state = ButtonPanelState.ACTIVE;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        state = ButtonPanelState.SIMPLE;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
}
