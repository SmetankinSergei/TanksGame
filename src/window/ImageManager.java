package window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    // bullet icons
    private static BufferedImage emptyClipImg;
    private static BufferedImage simpleBulletImg;
    private static BufferedImage fastBulletImg;
    private static BufferedImage powerBulletImg;

    // hero info panel
    private static BufferedImage bulletsAmountImg;
    private static BufferedImage heroInfoMain;
    private static BufferedImage clipUnitImg;

    // landscape
    private static BufferedImage waterImg;
    private static BufferedImage brickImg;
    private static BufferedImage damagedBrickImg;
    private static BufferedImage indestructibleImg;

    // hero simple tank
    private static BufferedImage upHeroTankSprite;
    private static BufferedImage downHeroTankSprite;
    private static BufferedImage leftHeroTankSprite;
    private static BufferedImage rightHeroTankSprite;

    // hero fast tank
    private static BufferedImage upHeroFastTankSprite;
    private static BufferedImage downHeroFastTankSprite;
    private static BufferedImage leftHeroFastTankSprite;
    private static BufferedImage rightHeroFastTankSprite;

    // hero power tank
    private static BufferedImage upHeroPowerTankSprite;
    private static BufferedImage downHeroPowerTankSprite;
    private static BufferedImage leftHeroPowerTankSprite;
    private static BufferedImage rightHeroPowerTankSprite;

    // hero super tank
    private static BufferedImage upHeroSuperTankSprite;
    private static BufferedImage downHeroSuperTankSprite;
    private static BufferedImage leftHeroSuperTankSprite;
    private static BufferedImage rightHeroSuperTankSprite;

    // simple enemy tank
    private static BufferedImage upSimpleEnemyTankSprite;
    private static BufferedImage downSimpleEnemyTankSprite;
    private static BufferedImage leftSimpleEnemyTankSprite;
    private static BufferedImage rightSimpleEnemyTankSprite;

    // fast enemy tank
    private static BufferedImage upFastEnemyTankSprite;
    private static BufferedImage downFastEnemyTankSprite;
    private static BufferedImage leftFastEnemyTankSprite;
    private static BufferedImage rightFastEnemyTankSprite;

    // power enemy tank
    private static BufferedImage upPowerEnemyTankSprite;
    private static BufferedImage downPowerEnemyTankSprite;
    private static BufferedImage leftPowerEnemyTankSprite;
    private static BufferedImage rightPowerEnemyTankSprite;

    // super enemy tank
    private static BufferedImage upSuperEnemyTankSprite;
    private static BufferedImage downSuperEnemyTankSprite;
    private static BufferedImage leftSuperEnemyTankSprite;
    private static BufferedImage rightSuperEnemyTankSprite;

    // flags
    private static BufferedImage greenFlagImg;
    private static BufferedImage redFlagImg;

    // bonus boxes
    private static BufferedImage smallHealthBoxImg;
    private static BufferedImage bigHealthBoxImg;
    private static BufferedImage simpleBulletBoxImg;
    private static BufferedImage fastBulletBoxImg;
    private static BufferedImage powerBulletBoxImg;

    // scale check images
    private static BufferedImage scaleCheckImg_150;
    private static BufferedImage scaleCheckImg_350;
    private static BufferedImage scaleCheckImg_450;

    // start panel
    private static BufferedImage startPanelImg;
    private static BufferedImage startButtonImg;
    private static BufferedImage activeStartButtonImg;
    private static BufferedImage pressedStartButtonImg;
    private static BufferedImage exitButtonImg;
    private static BufferedImage activeExitButtonImg;
    private static BufferedImage pressedExitButtonImg;
    private static BufferedImage optionsButtonImg;
    private static BufferedImage activeOptionsButtonImg;
    private static BufferedImage pressedOptionsButtonImg;

    // options panel
    private static BufferedImage optionsPanelImg;
    private static BufferedImage okImg;
    private static BufferedImage simpleOkImg;
    private static BufferedImage noImg;
    private static BufferedImage simpleNoImg;
    private static BufferedImage activeNoImg;
    private static BufferedImage pressedNoImg;
    private static BufferedImage backButtonImg;
    private static BufferedImage activeBackButtonImg;
    private static BufferedImage pressedBackButtonImg;

    // game menu panel
    private static BufferedImage gameMenuPanel;
    private static BufferedImage startMenuButtonImg;
    private static BufferedImage activeStartMenuButtonImg;
    private static BufferedImage pressedStartMenuButtonImg;
    private static BufferedImage exitGameButtonImg;
    private static BufferedImage activeExitGameButtonImg;
    private static BufferedImage pressedExitGameButtonImg;

    // end panels
    private static BufferedImage winPanelImg;
    private static BufferedImage lockImg;
    // stages
    private static BufferedImage startStageOneButtonImg;
    private static BufferedImage activeStartStageOneButtonImg;
    private static BufferedImage pressedStartStageOneButtonImg;
    private static BufferedImage startStageTwoButtonImg;
    private static BufferedImage activeStartStageTwoButtonImg;
    private static BufferedImage pressedStartStageTwoButtonImg;
    private static BufferedImage startStageThreeButtonImg;
    private static BufferedImage activeStartStageThreeButtonImg;
    private static BufferedImage pressedStartStageThreeButtonImg;
    private static BufferedImage startStageFourButtonImg;
    private static BufferedImage activeStartStageFourButtonImg;
    private static BufferedImage pressedStartStageFourButtonImg;
    // tanks
    private static BufferedImage simpleHeroTankImg;
    private static BufferedImage selectedHeroTankImg;
    private static BufferedImage activeSimpleHeroTankImg;
    private static BufferedImage pressedSimpleHeroTankImg;
    private static BufferedImage fastHeroTankImg;
    private static BufferedImage selectedFastHeroTankImg;
    private static BufferedImage activeFastHeroTankImg;
    private static BufferedImage pressedFastHeroTankImg;
    private static BufferedImage powerHeroTankImg;
    private static BufferedImage selectedPowerHeroTankImg;
    private static BufferedImage activePowerHeroTankImg;
    private static BufferedImage pressedPowerHeroTankImg;
    private static BufferedImage superHeroTankImg;
    private static BufferedImage selectedSuperHeroTankImg;
    private static BufferedImage activeSuperHeroTankImg;
    private static BufferedImage presserSuperHeroTankImg;
    private static BufferedImage endPanelImg;



    // sample panel
    private static BufferedImage getSampleField_1_Img;
    private static BufferedImage getSampleField_2_Img;
    private static BufferedImage getSampleField_3_Img;
    private static BufferedImage getSampleField_4_Img;

    private static BufferedImage clearImg;

    static {
        loadImages();
    }

    public static void scaleCheck(Graphics g, ImageObserver observer, int scale) {
        if (scale == 150) {
            g.drawImage(scaleCheckImg_150, 0, 0, observer);
            g.drawImage(scaleCheckImg_150, 450, 0, observer);
        }
        if (scale == 350) {
            g.drawImage(scaleCheckImg_350, 0, 0, observer);
            g.drawImage(scaleCheckImg_350, 450, 0, observer);
            g.drawImage(scaleCheckImg_350, 0, 350, observer);
            g.drawImage(scaleCheckImg_350, 450, 350, observer);
        }
        if (scale == 450) {
            g.drawImage(scaleCheckImg_450, 0, 0, observer);
            g.drawImage(scaleCheckImg_450, 450, 0, observer);
            g.drawImage(scaleCheckImg_450, 0, 450, observer);
            g.drawImage(scaleCheckImg_450, 450, 450, observer);

        }
    }

    private static void loadImages() {
        try {
            bulletsAmountImg = ImageIO.read(new File("img/hero_info/hero_info_bullets_amount.png"));
            heroInfoMain = ImageIO.read(new File("img/hero_info/hero_info_main.png"));
            clipUnitImg = ImageIO.read(new File("img/hero_info/clip_unit.png"));

            emptyClipImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/empty.png"));
            simpleBulletImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/simple_bullet_box.png"));
            fastBulletImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/fast_bullet_box.png"));
            powerBulletImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/power_bullet_box.png"));

            waterImg = ImageIO.read(new File("img/landscape/water.png"));
            brickImg = ImageIO.read(new File("img/landscape/brick.png"));
            damagedBrickImg = ImageIO.read(new File("img/landscape/damaged_brick.png"));
            indestructibleImg = ImageIO.read(new File("img/landscape/indestructible.png"));

            // hero simple tank
            upHeroTankSprite = ImageIO.read(new File("img/tanks/hero_tank/simple/hero_tank_up.png"));
            downHeroTankSprite = ImageIO.read(new File("img/tanks/hero_tank/simple/hero_tank_down.png"));
            leftHeroTankSprite = ImageIO.read(new File("img/tanks/hero_tank/simple/hero_tank_left.png"));
            rightHeroTankSprite = ImageIO.read(new File("img/tanks/hero_tank/simple/hero_tank_right.png"));

            // hero fast tank
            upHeroFastTankSprite = ImageIO.read(new File("img/tanks/hero_tank/fast/hero_fast_tank_up.png"));
            downHeroFastTankSprite = ImageIO.read(new File("img/tanks/hero_tank/fast/hero_fast_tank_down.png"));
            leftHeroFastTankSprite = ImageIO.read(new File("img/tanks/hero_tank/fast/hero_fast_tank_left.png"));
            rightHeroFastTankSprite = ImageIO.read(new File("img/tanks/hero_tank/fast/hero_fast_tank_right.png"));

            // hero power tank
            upHeroPowerTankSprite = ImageIO.read(new File("img/tanks/hero_tank/power/hero_power_tank_up.png"));
            downHeroPowerTankSprite = ImageIO.read(new File("img/tanks/hero_tank/power/hero_power_tank_down.png"));
            leftHeroPowerTankSprite = ImageIO.read(new File("img/tanks/hero_tank/power/hero_power_tank_left.png"));
            rightHeroPowerTankSprite = ImageIO.read(new File("img/tanks/hero_tank/power/hero_power_tank_right.png"));

            // hero super tank
            upHeroSuperTankSprite = ImageIO.read(new File("img/tanks/hero_tank/super/hero_super_tank_up.png"));
            downHeroSuperTankSprite = ImageIO.read(new File("img/tanks/hero_tank/super/hero_super_tank_down.png"));
            leftHeroSuperTankSprite = ImageIO.read(new File("img/tanks/hero_tank/super/hero_super_tank_left.png"));
            rightHeroSuperTankSprite = ImageIO.read(new File("img/tanks/hero_tank/super/hero_super_tank_right.png"));

            // enemy simple tank
            upSimpleEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/simple_enemy_tank/simple_enemy_tank_up.png"));
            downSimpleEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/simple_enemy_tank/simple_enemy_tank_down.png"));
            leftSimpleEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/simple_enemy_tank/simple_enemy_tank_left.png"));
            rightSimpleEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/simple_enemy_tank/simple_enemy_tank_right.png"));

            // enemy fast tank
            upFastEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/fast_enemy_tank/fast_enemy_tank_up.png"));
            downFastEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/fast_enemy_tank/fast_enemy_tank_down.png"));
            leftFastEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/fast_enemy_tank/fast_enemy_tank_left.png"));
            rightFastEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/fast_enemy_tank/fast_enemy_tank_right.png"));

            // enemy power tank
            upPowerEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/power_enemy_tank/power_enemy_tank_up.png"));
            downPowerEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/power_enemy_tank/power_enemy_tank_down.png"));
            leftPowerEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/power_enemy_tank/power_enemy_tank_left.png"));
            rightPowerEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/power_enemy_tank/power_enemy_tank_right.png"));

            // enemy super tank
            upSuperEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/super_enemy_tank/super_enemy_tank_up.png"));
            downSuperEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/super_enemy_tank/super_enemy_tank_down.png"));
            leftSuperEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/super_enemy_tank/super_enemy_tank_left.png"));
            rightSuperEnemyTankSprite = ImageIO.read(new File("img/tanks/enemy_tank/super_enemy_tank/super_enemy_tank_right.png"));

            greenFlagImg = ImageIO.read(new File("img/landscape/flags/green_flag.png"));
            redFlagImg = ImageIO.read(new File("img/landscape/flags/red_flag.png"));

            bigHealthBoxImg = ImageIO.read(new File("img/bonus_boxes/health_boxes/big_health_box.png"));
            smallHealthBoxImg = ImageIO.read(new File("img/bonus_boxes/health_boxes/small_health_box.png"));

            simpleBulletBoxImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/simple_bullet_box.png"));
            fastBulletBoxImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/fast_bullet_box.png"));
            powerBulletBoxImg = ImageIO.read(new File("img/bonus_boxes/bullet_boxes/power_bullet_box.png"));

            scaleCheckImg_150 = ImageIO.read(new File("img/scale_check/scale_check_450_150.png"));
            scaleCheckImg_350 = ImageIO.read(new File("img/scale_check/scale_check_450_350.png"));
            scaleCheckImg_450 = ImageIO.read(new File("img/scale_check/scale_check_450_450.png"));

            startPanelImg = ImageIO.read(new File("img/panels/start_panel/start_panel_img.png"));
            startButtonImg = ImageIO.read(new File("img/panels/start_panel/start_button.png"));
            activeStartButtonImg = ImageIO.read(new File("img/panels/start_panel/active_start_button.png"));
            pressedStartButtonImg = ImageIO.read(new File("img/panels/start_panel/pressed_start_button.png"));
            exitButtonImg = ImageIO.read(new File("img/panels/start_panel/exit_button_sp.png"));
            activeExitButtonImg = ImageIO.read(new File("img/panels/start_panel/active_exit_button_sp.png"));
            pressedExitButtonImg = ImageIO.read(new File("img/panels/start_panel/pressed_exit_button_sp.png"));
            optionsButtonImg = ImageIO.read(new File("img/panels/start_panel/options_button.png"));
            activeOptionsButtonImg = ImageIO.read(new File("img/panels/start_panel/active_options_button.png"));
            pressedOptionsButtonImg = ImageIO.read(new File("img/panels/start_panel/pressed_options_button.png"));

            optionsPanelImg = ImageIO.read(new File("img/panels/options_panel/options_panel.png"));
            okImg = ImageIO.read(new File("img/panels/options_panel/ok_img.png"));
            simpleOkImg = ImageIO.read(new File("img/panels/options_panel/simple_ok_img.png"));
            noImg = ImageIO.read(new File("img/panels/options_panel/no_img.png"));
            simpleNoImg = ImageIO.read(new File("img/panels/options_panel/simple_no_img.png"));
            activeNoImg = ImageIO.read(new File("img/panels/options_panel/active_no_img.png"));
            pressedNoImg = ImageIO.read(new File("img/panels/options_panel/pressed_no_img.png"));
            backButtonImg = ImageIO.read(new File("img/panels/options_panel/back_button.png"));
            activeBackButtonImg = ImageIO.read(new File("img/panels/options_panel/active_back_button.png"));
            pressedBackButtonImg = ImageIO.read(new File("img/panels/options_panel/pressed_back_button.png"));

            gameMenuPanel = ImageIO.read(new File("img/panels/game_menu_panel/game_menu_panel.png"));
            startMenuButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/start_menu_button.png"));
            activeStartMenuButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/active_start_menu_button.png"));
            pressedStartMenuButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/pressed_start_menu_button.png"));
            exitGameButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/exit_game_button.png"));
            activeExitGameButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/active_exit_game_button.png"));
            pressedExitGameButtonImg = ImageIO.read(new File("img/panels/game_menu_panel/pressed_exit_game_button.png"));

            winPanelImg = ImageIO.read(new File("img/panels/win_panel/win_panel.png"));
            lockImg = ImageIO.read(new File("img/panels/win_panel/lock.png"));
            // stages
            startStageOneButtonImg = ImageIO.read(new File("img/panels/win_panel/stage_one.png"));
            activeStartStageOneButtonImg = ImageIO.read(new File("img/panels/win_panel/active_stage_one.png"));
            pressedStartStageOneButtonImg = ImageIO.read(new File("img/panels/win_panel/pressed_stage_one.png"));
            startStageTwoButtonImg = ImageIO.read(new File("img/panels/win_panel/stage_two.png"));
            activeStartStageTwoButtonImg = ImageIO.read(new File("img/panels/win_panel/active_stage_two.png"));
            pressedStartStageTwoButtonImg = ImageIO.read(new File("img/panels/win_panel/pressed_stage_two.png"));
            startStageThreeButtonImg = ImageIO.read(new File("img/panels/win_panel/stage_three.png"));
            activeStartStageThreeButtonImg = ImageIO.read(new File("img/panels/win_panel/active_stage_three.png"));
            pressedStartStageThreeButtonImg = ImageIO.read(new File("img/panels/win_panel/pressed_stage_three.png"));
            startStageFourButtonImg = ImageIO.read(new File("img/panels/win_panel/stage_four.png"));
            activeStartStageFourButtonImg = ImageIO.read(new File("img/panels/win_panel/active_stage_four.png"));
            pressedStartStageFourButtonImg = ImageIO.read(new File("img/panels/win_panel/pressed_stage_four.png"));
            // tanks
            simpleHeroTankImg = ImageIO.read(new File("img/panels/win_panel/simple_tank.png"));
            selectedHeroTankImg = ImageIO.read(new File("img/panels/win_panel/selected_simple_tank.png"));
            activeSimpleHeroTankImg = ImageIO.read(new File("img/panels/win_panel/active_simple_tank.png"));
            pressedSimpleHeroTankImg = ImageIO.read(new File("img/panels/win_panel/pressed_simple_tank.png"));
            fastHeroTankImg = ImageIO.read(new File("img/panels/win_panel/fast_tank.png"));
            selectedFastHeroTankImg = ImageIO.read(new File("img/panels/win_panel/selected_fast_tank.png"));
            activeFastHeroTankImg = ImageIO.read(new File("img/panels/win_panel/active_fast_tank.png"));
            pressedFastHeroTankImg = ImageIO.read(new File("img/panels/win_panel/pressed_fast_tank.png"));
            powerHeroTankImg = ImageIO.read(new File("img/panels/win_panel/power_tank.png"));
            selectedPowerHeroTankImg = ImageIO.read(new File("img/panels/win_panel/selected_power_tank.png"));
            activePowerHeroTankImg = ImageIO.read(new File("img/panels/win_panel/active_power_tank.png"));
            pressedPowerHeroTankImg = ImageIO.read(new File("img/panels/win_panel/pressed_power_tank.png"));
            superHeroTankImg = ImageIO.read(new File("img/panels/win_panel/super_tank.png"));
            selectedSuperHeroTankImg = ImageIO.read(new File("img/panels/win_panel/selected_super_tank.png"));
            activeSuperHeroTankImg = ImageIO.read(new File("img/panels/win_panel/active_super_tank.png"));
            presserSuperHeroTankImg = ImageIO.read(new File("img/panels/win_panel/pressed_super_tank.png"));
            endPanelImg = ImageIO.read(new File("img/panels/end_panel/end_panel.png"));

            getSampleField_1_Img = ImageIO.read(new File("img/sample_field/sample_field_1.png"));
            getSampleField_2_Img = ImageIO.read(new File("img/sample_field/sample_field_2.png"));
            getSampleField_3_Img = ImageIO.read(new File("img/sample_field/sample_field_3.png"));
            getSampleField_4_Img = ImageIO.read(new File("img/sample_field/sample_field_4.png"));

            clearImg = ImageIO.read(new File("img/landscape/clear.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getEmptyClipImg() {
        return emptyClipImg;
    }

    public static BufferedImage getSimpleBulletImg() {
        return simpleBulletImg;
    }

    public static BufferedImage getFastBulletImg() {
        return fastBulletImg;
    }

    public static BufferedImage getPowerBulletImg() {
        return powerBulletImg;
    }

    public static BufferedImage getBulletsAmountImg() {
        return bulletsAmountImg;
    }

    public static BufferedImage getHeroInfoMain() {
        return heroInfoMain;
    }

    public static BufferedImage getClipUnitImg() {
        return clipUnitImg;
    }

    public static BufferedImage getWaterImg() {
        return waterImg;
    }

    public static BufferedImage getBrickImg() {
        return brickImg;
    }

    public static BufferedImage getDamagedBrickImg() {
        return damagedBrickImg;
    }

    public static BufferedImage getUpHeroTankSprite() {
        return upHeroTankSprite;
    }

    public static BufferedImage getDownHeroTankSprite() {
        return downHeroTankSprite;
    }

    public static BufferedImage getLeftHeroTankSprite() {
        return leftHeroTankSprite;
    }

    public static BufferedImage getRightHeroTankSprite() {
        return rightHeroTankSprite;
    }

    public static BufferedImage getUpHeroFastTankSprite() {
        return upHeroFastTankSprite;
    }

    public static BufferedImage getDownHeroFastTankSprite() {
        return downHeroFastTankSprite;
    }

    public static BufferedImage getLeftHeroFastTankSprite() {
        return leftHeroFastTankSprite;
    }

    public static BufferedImage getRightHeroFastTankSprite() {
        return rightHeroFastTankSprite;
    }

    public static BufferedImage getUpSimpleEnemyTankSprite() {
        return upSimpleEnemyTankSprite;
    }

    public static BufferedImage getDownSimpleEnemyTankSprite() {
        return downSimpleEnemyTankSprite;
    }

    public static BufferedImage getLeftSimpleEnemyTankSprite() {
        return leftSimpleEnemyTankSprite;
    }

    public static BufferedImage getRightSimpleEnemyTankSprite() {
        return rightSimpleEnemyTankSprite;
    }

    public static BufferedImage getUpFastEnemyTankSprite() {
        return upFastEnemyTankSprite;
    }

    public static BufferedImage getDownFastEnemyTankSprite() {
        return downFastEnemyTankSprite;
    }

    public static BufferedImage getLeftFastEnemyTankSprite() {
        return leftFastEnemyTankSprite;
    }

    public static BufferedImage getRightFastEnemyTankSprite() {
        return rightFastEnemyTankSprite;
    }

    public static BufferedImage getUpPowerEnemyTankSprite() {
        return upPowerEnemyTankSprite;
    }

    public static BufferedImage getUpSuperEnemyTankSprite() {
        return upSuperEnemyTankSprite;
    }

    public static BufferedImage getDownSuperEnemyTankSprite() {
        return downSuperEnemyTankSprite;
    }

    public static BufferedImage getLeftSuperEnemyTankSprite() {
        return leftSuperEnemyTankSprite;
    }

    public static BufferedImage getRightSuperEnemyTankSprite() {
        return rightSuperEnemyTankSprite;
    }

    public static BufferedImage getGreenFlagImg() {
        return greenFlagImg;
    }

    public static BufferedImage getRedFlagImg() {
        return redFlagImg;
    }

    public static BufferedImage getDownPowerEnemyTankSprite() {
        return downPowerEnemyTankSprite;
    }

    public static BufferedImage getLeftPowerEnemyTankSprite() {
        return leftPowerEnemyTankSprite;
    }

    public static BufferedImage getRightPowerEnemyTankSprite() {
        return rightPowerEnemyTankSprite;
    }

    public static BufferedImage getSmallHealthBoxImg() {
        return smallHealthBoxImg;
    }

    public static BufferedImage getBigHealthBoxImg() {
        return bigHealthBoxImg;
    }

    public static BufferedImage getSimpleBulletBoxImg() {
        return simpleBulletBoxImg;
    }

    public static BufferedImage getFastBulletBoxImg() {
        return fastBulletBoxImg;
    }

    public static BufferedImage getPowerBulletBoxImg() {
        return powerBulletBoxImg;
    }

    public static BufferedImage getStartPanelImg() {
        return startPanelImg;
    }

    public static BufferedImage getStartButtonImg() {
        return startButtonImg;
    }

    public static BufferedImage getActiveStartButtonImg() {
        return activeStartButtonImg;
    }

    public static BufferedImage getPressedStartButtonImg() {
        return pressedStartButtonImg;
    }

    public static BufferedImage getExitButtonImg() {
        return exitButtonImg;
    }

    public static BufferedImage getActiveExitButtonImg() {
        return activeExitButtonImg;
    }

    public static BufferedImage getPressedExitButtonImg() {
        return pressedExitButtonImg;
    }

    public static BufferedImage getOptionsButtonImg() {
        return optionsButtonImg;
    }

    public static BufferedImage getActiveOptionsButtonImg() {
        return activeOptionsButtonImg;
    }

    public static BufferedImage getPressedOptionsButtonImg() {
        return pressedOptionsButtonImg;
    }

    public static BufferedImage getOptionsPanelImg() {
        return optionsPanelImg;
    }

    public static BufferedImage getSimpleOkImg() {
        return simpleOkImg;
    }

    public static BufferedImage getSimpleNoImg() {
        return simpleNoImg;
    }

    public static BufferedImage getOkImg() {
        return okImg;
    }

    public static BufferedImage getNoImg() {
        return noImg;
    }

    public static BufferedImage getActiveNoImg() {
        return activeNoImg;
    }

    public static BufferedImage getPressedNoImg() {
        return pressedNoImg;
    }

    public static BufferedImage getBackButtonImg() {
        return backButtonImg;
    }

    public static BufferedImage getActiveBackButtonImg() {
        return activeBackButtonImg;
    }

    public static BufferedImage getPressedBackButtonImg() {
        return pressedBackButtonImg;
    }

    public static BufferedImage getGameMenuPanel() {
        return gameMenuPanel;
    }

    public static BufferedImage getStartMenuButtonImg() {
        return startMenuButtonImg;
    }

    public static BufferedImage getActiveStartMenuButtonImg() {
        return activeStartMenuButtonImg;
    }

    public static BufferedImage getPressedStartMenuButtonImg() {
        return pressedStartMenuButtonImg;
    }

    public static BufferedImage getExitGameButtonImg() {
        return exitGameButtonImg;
    }

    public static BufferedImage getActiveExitGameButtonImg() {
        return activeExitGameButtonImg;
    }

    public static BufferedImage getPressedExitGameButtonImg() {
        return pressedExitGameButtonImg;
    }

    public static BufferedImage getIndestructibleImg() {
        return indestructibleImg;
    }

    public static BufferedImage getWinPanelImg() {
        return winPanelImg;
    }

    public static BufferedImage getLockImg() {
        return lockImg;
    }

    public static BufferedImage getStartStageOneButtonImg() {
        return startStageOneButtonImg;
    }

    public static BufferedImage getActiveStartStageOneButtonImg() {
        return activeStartStageOneButtonImg;
    }

    public static BufferedImage getPressedStartStageOneButtonImg() {
        return pressedStartStageOneButtonImg;
    }

    public static BufferedImage getStartStageTwoButtonImg() {
        return startStageTwoButtonImg;
    }

    public static BufferedImage getActiveStartStageTwoButtonImg() {
        return activeStartStageTwoButtonImg;
    }

    public static BufferedImage getPressedStartStageTwoButtonImg() {
        return pressedStartStageTwoButtonImg;
    }

    public static BufferedImage getStartStageThreeButtonImg() {
        return startStageThreeButtonImg;
    }

    public static BufferedImage getActiveStartStageThreeButtonImg() {
        return activeStartStageThreeButtonImg;
    }

    public static BufferedImage getPressedStartStageThreeButtonImg() {
        return pressedStartStageThreeButtonImg;
    }

    public static BufferedImage getStartStageFourButtonImg() {
        return startStageFourButtonImg;
    }

    public static BufferedImage getActiveStartStageFourButtonImg() {
        return activeStartStageFourButtonImg;
    }

    public static BufferedImage getPressedStartStageFourButtonImg() {
        return pressedStartStageFourButtonImg;
    }

    public static BufferedImage getSimpleHeroTankImg() {
        return simpleHeroTankImg;
    }

    public static BufferedImage getActiveSimpleHeroTankImg() {
        return activeSimpleHeroTankImg;
    }

    public static BufferedImage getPressedSimpleHeroTankImg() {
        return pressedSimpleHeroTankImg;
    }

    public static BufferedImage getFastHeroTankImg() {
        return fastHeroTankImg;
    }

    public static BufferedImage getActiveFastHeroTankImg() {
        return activeFastHeroTankImg;
    }

    public static BufferedImage getPressedFastHeroTankImg() {
        return pressedFastHeroTankImg;
    }

    public static BufferedImage getPowerHeroTankImg() {
        return powerHeroTankImg;
    }

    public static BufferedImage getUpHeroPowerTankSprite() {
        return upHeroPowerTankSprite;
    }

    public static BufferedImage getDownHeroPowerTankSprite() {
        return downHeroPowerTankSprite;
    }

    public static BufferedImage getLeftHeroPowerTankSprite() {
        return leftHeroPowerTankSprite;
    }

    public static BufferedImage getRightHeroPowerTankSprite() {
        return rightHeroPowerTankSprite;
    }

    public static BufferedImage getUpHeroSuperTankSprite() {
        return upHeroSuperTankSprite;
    }

    public static BufferedImage getDownHeroSuperTankSprite() {
        return downHeroSuperTankSprite;
    }

    public static BufferedImage getLeftHeroSuperTankSprite() {
        return leftHeroSuperTankSprite;
    }

    public static BufferedImage getRightHeroSuperTankSprite() {
        return rightHeroSuperTankSprite;
    }

    public static BufferedImage getActivePowerHeroTankImg() {
        return activePowerHeroTankImg;
    }

    public static BufferedImage getPressedPowerHeroTankImg() {
        return pressedPowerHeroTankImg;
    }

    public static BufferedImage getSuperHeroTankImg() {
        return superHeroTankImg;
    }

    public static BufferedImage getActiveSuperHeroTankImg() {
        return activeSuperHeroTankImg;
    }

    public static BufferedImage getPresserSuperHeroTankImg() {
        return presserSuperHeroTankImg;
    }

    public static BufferedImage getSelectedHeroTankImg() {
        return selectedHeroTankImg;
    }

    public static BufferedImage getSelectedFastHeroTankImg() {
        return selectedFastHeroTankImg;
    }

    public static BufferedImage getSelectedPowerHeroTankImg() {
        return selectedPowerHeroTankImg;
    }

    public static BufferedImage getSelectedSuperHeroTankImg() {
        return selectedSuperHeroTankImg;
    }

    public static BufferedImage getEndPanelImg() {
        return endPanelImg;
    }

    public static BufferedImage getGetSampleField_1_Img() {
        return getSampleField_1_Img;
    }

    public static BufferedImage getGetSampleField_2_Img() {
        return getSampleField_2_Img;
    }

    public static BufferedImage getGetSampleField_3_Img() {
        return getSampleField_3_Img;
    }

    public static BufferedImage getGetSampleField_4_Img() {
        return getSampleField_4_Img;
    }

    public static BufferedImage getClearImg() {
        return clearImg;
    }
}
