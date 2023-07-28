package window.panels;

import game_objects.GameObject;
import game_objects.landscape.flags.EnemyFlag;
import game_objects.landscape.flags.HeroFlag;
import game_objects.tanks.*;
import window.*;
import window.Window;
import window.map_creator.FieldMapCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class Stage extends SamplePanel implements ActionListener {

    ScreenState state;
    private Timer timer;

    public List<GameObject> bullets = new ArrayList<>();
    HeroTank hero;
    List<GameObject> tanks = new ArrayList<>();
    List<GameObject> flags = new ArrayList<>();
    List<GameObject> field;
    JPanel heroInfoPanel;
    GameMenuPanel gameMenuPanel;

    public Stage(Window window, Controller controller, ScreenState state) {
        super(window, controller);
        this.state = state;
        controller.setScreenState(state);
        hero = new HeroTank(this, window.getTypeMoveControl(), controller.getTypeTank(), 431, 590);
        heroInfoPanel = new HeroInfoPanel(hero);
        tanks.add(hero);
        addEnemies();
        field = FieldMapCreator.getMap(this, state, window.getWidth(), window.getHeight());
        setFlagsOnField(state);
        controller.setStage(this);
        gameMenuPanel = new GameMenuPanel(window, controller);
        add(heroInfoPanel);
        add(gameMenuPanel);
        heroInfoPanel.setLocation(0, 700);
        heroInfoPanel.setSize(900, 197);
        timer = new Timer(15, this);
        timer.start();
        setFocusable(true); // for key listener
    }


    public Timer getTimer() {
        return timer;
    }

    private void addEnemies() {
        EnemyTank enemyTank_1 = new PowerEnemyTank(this, 200, 10);
        EnemyTank enemyTank_2 = new FastEnemyTank(this, 280, 30);
        EnemyTank enemyTank_3 = new SimpleEnemyTank(this, 850, 330);
        EnemyTank enemyTank_4 = new SuperEnemyTank(this, 680, 80);
        EnemyTank enemyTank_5 = new SimpleEnemyTank(this, 10, 650);
        EnemyTank enemyTank_6 = new FastEnemyTank(this, 55, 650);
        EnemyTank enemyTank_7 = new SimpleEnemyTank(this, 100, 650);
        EnemyTank enemyTank_8 = new FastEnemyTank(this, 750, 650);
        EnemyTank enemyTank_9 = new SimpleEnemyTank(this, 800, 650);
        EnemyTank enemyTank_10 = new FastEnemyTank(this, 850, 650);
        tanks.add(enemyTank_1);
        tanks.add(enemyTank_2);
        tanks.add(enemyTank_3);
        tanks.add(enemyTank_4);
        tanks.add(enemyTank_5);
//        tanks.add(enemyTank_6);
//        tanks.add(enemyTank_7);
//        tanks.add(enemyTank_8);
//        tanks.add(enemyTank_9);
//        tanks.add(enemyTank_10);
    }

    private void setFlagsOnField(ScreenState state) {
        if (state == ScreenState.STAGE_1 || state == ScreenState.STAGE_2 ||
                state == ScreenState.STAGE_3 || state == ScreenState.STAGE_4) {
            flags.add(new HeroFlag(432, 662, this));
            flags.add(new EnemyFlag(10, 10, this));
            flags.add(new EnemyFlag(854, 10, this));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (window.getKey() == KeyEvent.VK_ESCAPE) {
            gameMenuPanel.setVisible(true);
            window.setKey(KeyEvent.VK_U);
        }
        controller.update(bullets, field, tanks, flags);
        repaint();
    }

//    private void drawFieldImage(Graphics g, ScreenState state) {
//        if (state == ScreenState.STAGE_1) {
//            g.drawImage(ImageManager.getGetSampleField_1_Img(), 0, 0, this);
//            g.drawImage(ImageManager.getGetSampleField_2_Img(), 450, 0, this);
//            g.drawImage(ImageManager.getGetSampleField_3_Img(), 0, 350, this);
//            g.drawImage(ImageManager.getGetSampleField_4_Img(), 450, 350, this);
//        }
//    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //drawFieldImage(g, state);
        controller.render(g, field, bullets, tanks, flags);
        //ServiceClass.scaleCheck(g, this, 350);
    }
}
