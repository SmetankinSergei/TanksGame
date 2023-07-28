package window.buttons;

import window.Window;
import window.panels.GameMenuPanel;

import java.awt.event.MouseEvent;

public class BackToGameButtonPanel extends ButtonPanel {

    GameMenuPanel gameMenuPanel;

    public BackToGameButtonPanel(Window window, TypeButton typeButton, GameMenuPanel gameMenuPanel) {
        super(window, typeButton);
        this.gameMenuPanel = gameMenuPanel;
    }

    @Override
    public void  mouseReleased(MouseEvent e) {
        gameMenuPanel.setVisible(false);
    }
}
