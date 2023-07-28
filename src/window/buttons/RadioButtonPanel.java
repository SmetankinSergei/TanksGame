package window.buttons;

import window.ImageManager;
import window.Window;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RadioButtonPanel extends SampleButtonPanel {

    private boolean isActive;
    private boolean isClicked;
    private final RadioOwner owner;

    public RadioButtonPanel(Window window, TypeButton typeButton, RadioOwner owner, boolean isActive) {
        super(window, typeButton, ButtonPanelState.SIMPLE);
        this.owner = owner;
        this.isActive = isActive;
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = ImageManager.getNoImg();

        if (isActive) {
            if (typeButton == TypeButton.MOVE_OPTIONS_RADIO_BUTTON) image = ImageManager.getOkImg();
            if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getSelectedHeroTankImg();
            if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getSelectedFastHeroTankImg();
            if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getSelectedPowerHeroTankImg();
            if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getSelectedSuperHeroTankImg();
        }
        if (!isActive) {
            if (state == ButtonPanelState.SIMPLE) {
                if (typeButton == TypeButton.MOVE_OPTIONS_RADIO_BUTTON) image = ImageManager.getNoImg();
                if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getSimpleHeroTankImg();
                if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getFastHeroTankImg();
                if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getPowerHeroTankImg();
                if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getSuperHeroTankImg();
            } else if (state == ButtonPanelState.ACTIVE) {
                if (typeButton == TypeButton.MOVE_OPTIONS_RADIO_BUTTON) image = ImageManager.getActiveNoImg();
                if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getActiveSimpleHeroTankImg();
                if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getActiveFastHeroTankImg();
                if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getActivePowerHeroTankImg();
                if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getActiveSuperHeroTankImg();
            } else if (state == ButtonPanelState.PRESSED) {
                if (typeButton == TypeButton.MOVE_OPTIONS_RADIO_BUTTON) image = ImageManager.getPressedNoImg();
                if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getPressedSimpleHeroTankImg();
                if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getPressedFastHeroTankImg();
                if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getPressedPowerHeroTankImg();
                if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getPresserSuperHeroTankImg();
            }
        }
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isActive) return;
        isClicked = true;
        owner.updRadioButtonsGroup();
        repaint();
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
