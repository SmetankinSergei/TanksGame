package window.buttons;

import window.ImageManager;
import window.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ButtonPanel extends SampleButtonPanel {

    TypeButton typeButton;

    public ButtonPanel (Window window, TypeButton typeButton) {
        super(window, typeButton, ButtonPanelState.SIMPLE);
        this.typeButton = typeButton;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage image = ImageManager.getNoImg();

        if (state == ButtonPanelState.SIMPLE) {
            if (typeButton == TypeButton.START_BUTTON) image = ImageManager.getStartButtonImg();
            else if (typeButton == TypeButton.OPTIONS_BUTTON) image = ImageManager.getOptionsButtonImg();
            else if (typeButton == TypeButton.START_MENU_BUTTON) image = ImageManager.getStartMenuButtonImg();
            else if (typeButton == TypeButton.EXIT_GAME_BUTTON) image = ImageManager.getExitGameButtonImg();
            else if (typeButton == TypeButton.BACK_TO_GAME_BUTTON) image = ImageManager.getBackButtonImg();
            else if (typeButton == TypeButton.BACK_BUTTON) image = ImageManager.getBackButtonImg();
            else if (typeButton == TypeButton.EXIT_BUTTON) image = ImageManager.getExitButtonImg();
            else if (typeButton == TypeButton.START_STAGE_1) image = ImageManager.getStartStageOneButtonImg();
            else if (typeButton == TypeButton.START_STAGE_2) image = ImageManager.getStartStageTwoButtonImg();
            else if (typeButton == TypeButton.START_STAGE_3) image = ImageManager.getStartStageThreeButtonImg();
            else if (typeButton == TypeButton.START_STAGE_4) image = ImageManager.getStartStageFourButtonImg();
            else if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getSimpleHeroTankImg();
            else if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getFastHeroTankImg();
            else if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getPowerHeroTankImg();
            else if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getSuperHeroTankImg();
            else throw new RuntimeException("From ButtonPanel: unknown type button: " + typeButton);
        } else
        if (state == ButtonPanelState.ACTIVE) {
            if (typeButton == TypeButton.START_BUTTON) image = ImageManager.getActiveStartButtonImg();
            else if (typeButton == TypeButton.OPTIONS_BUTTON) image = ImageManager.getActiveOptionsButtonImg();
            else if (typeButton == TypeButton.START_MENU_BUTTON) image = ImageManager.getActiveStartMenuButtonImg();
            else if (typeButton == TypeButton.EXIT_GAME_BUTTON) image = ImageManager.getActiveExitGameButtonImg();
            else if (typeButton == TypeButton.BACK_TO_GAME_BUTTON) image = ImageManager.getActiveBackButtonImg();
            else if (typeButton == TypeButton.BACK_BUTTON) image = ImageManager.getActiveBackButtonImg();
            else if (typeButton == TypeButton.EXIT_BUTTON) image = ImageManager.getActiveExitButtonImg();
            else if (typeButton == TypeButton.START_STAGE_1) image = ImageManager.getActiveStartStageOneButtonImg();
            else if (typeButton == TypeButton.START_STAGE_2) image = ImageManager.getActiveStartStageTwoButtonImg();
            else if (typeButton == TypeButton.START_STAGE_3) image = ImageManager.getActiveStartStageThreeButtonImg();
            else if (typeButton == TypeButton.START_STAGE_4) image = ImageManager.getActiveStartStageFourButtonImg();
            else if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getActiveSimpleHeroTankImg();
            else if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getActiveFastHeroTankImg();
            else if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getActivePowerHeroTankImg();
            else if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getActiveSuperHeroTankImg();
            else throw new RuntimeException("From ButtonPanel: unknown type button: " + typeButton);
        } else
        if (state == ButtonPanelState.PRESSED) {
            if (typeButton == TypeButton.START_BUTTON) image = ImageManager.getPressedStartButtonImg();
            else if (typeButton == TypeButton.OPTIONS_BUTTON) image = ImageManager.getPressedOptionsButtonImg();
            else if (typeButton == TypeButton.START_MENU_BUTTON) image = ImageManager.getPressedStartMenuButtonImg();
            else if (typeButton == TypeButton.EXIT_GAME_BUTTON) image = ImageManager.getPressedExitGameButtonImg();
            else if (typeButton == TypeButton.BACK_TO_GAME_BUTTON) image = ImageManager.getPressedBackButtonImg();
            else if (typeButton == TypeButton.BACK_BUTTON) image = ImageManager.getPressedBackButtonImg();
            else if (typeButton == TypeButton.EXIT_BUTTON) image = ImageManager.getPressedExitButtonImg();
            else if (typeButton == TypeButton.START_STAGE_1) image = ImageManager.getPressedStartStageOneButtonImg();
            else if (typeButton == TypeButton.START_STAGE_2) image = ImageManager.getPressedStartStageTwoButtonImg();
            else if (typeButton == TypeButton.START_STAGE_3) image = ImageManager.getPressedStartStageThreeButtonImg();
            else if (typeButton == TypeButton.START_STAGE_4) image = ImageManager.getPressedStartStageFourButtonImg();
            else if (typeButton == TypeButton.SIMPLE_HERO_TANK) image = ImageManager.getPressedSimpleHeroTankImg();
            else if (typeButton == TypeButton.FAST_HERO_TANK) image = ImageManager.getPressedFastHeroTankImg();
            else if (typeButton == TypeButton.POWER_HERO_TANK) image = ImageManager.getPressedPowerHeroTankImg();
            else if (typeButton == TypeButton.SUPER_HERO_TANK) image = ImageManager.getPresserSuperHeroTankImg();
            else throw new RuntimeException("From ButtonPanel: unknown type button: " + typeButton);
        }
        g.drawImage(image, 0, 0, this);
    }
}
