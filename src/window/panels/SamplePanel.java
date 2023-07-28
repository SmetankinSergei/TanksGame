package window.panels;

import window.Controller;
import window.ImageManager;
import window.Window;
import window.buttons.SampleButtonPanel;

import javax.swing.*;
import java.awt.*;

public abstract class SamplePanel extends JPanel {

    Window window;
    Controller controller;

    public SamplePanel(Window window, Controller controller) {
        this.window = window;
        this.controller = controller;
        setLayout(null);
    }

    public void addButtonPanel(SampleButtonPanel panel, Controller controller, int x, int y, int width, int height) {
        add(panel);
        panel.setLocation(x, y);
        panel.setSize(width, height);
        panel.setController(controller);
    }

    public void addMarkPanel(MarkPanel panel, int x, int y, int width, int height) {
        add(panel);
        panel.setLocation(x, y);
        panel.setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this instanceof StartMenuPanel) g.drawImage(ImageManager.getStartPanelImg(), 100, 75, this);
        if (this instanceof OptionsPanel) g.drawImage(ImageManager.getOptionsPanelImg(), 100, 75, this);
        if (this instanceof GameMenuPanel) g.drawImage(ImageManager.getGameMenuPanel(), 0, 0, this);
        if (this instanceof EndPanel) g.drawImage(ImageManager.getEndPanelImg(), 100, 75, this);
        if (this instanceof WinPanel) g.drawImage(ImageManager.getWinPanelImg(), 100, 75, this);
        if (this instanceof WinPanel) g.drawImage(ImageManager.getWinPanelImg(), 100, 75, this);
    }
}
