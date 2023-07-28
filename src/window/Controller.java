package window;

import game_objects.Attackable;
import game_objects.ammo.TypeBullet;
import game_objects.bonusBoxes.*;
import game_objects.ammo.Bullet;
import game_objects.GameObject;
import game_objects.Impassable;
import game_objects.landscape.Indestructible;
import game_objects.landscape.flags.EnemyFlag;
import game_objects.landscape.flags.Flag;
import game_objects.landscape.flags.HeroFlag;
import game_objects.tanks.EnemyTank;
import game_objects.tanks.HeroTank;
import game_objects.tanks.Tank;
import game_objects.tanks.TypeTank;
import window.panels.Stage;
import window.panels.StageListener;

import java.awt.*;
import java.util.List;

public class Controller implements StageListener {

    private final Window window;
    private SessionProgress sessionProgress = SessionProgress.STAGE_ONE;
    private TypeTank typeTank = TypeTank.SIMPLE;
    private Stage stage;
    ScreenState state = ScreenState.HERO_WIN_STAGE_ONE;
    private int flagCount = 0;
    private List<GameObject> flags;

    public void setScreenState(ScreenState state) {
        this.state = state;
    }

    public Controller(Window window) {
        this.window = window;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void updState(ScreenState state) {
        this.state = state;
        window.setState(state);
        window.updContainer(state);
    }

    private void updateMovableObjects(List<GameObject> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) instanceof Bullet) ((Bullet) objects.get(i)).update();
            if (objects.get(i) instanceof Tank) ((Tank) objects.get(i)).update(window.getKey());
        }
    }

    private void checkBulletCollision(List<GameObject> bullets, List<GameObject> gameObjects) {
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < gameObjects.size(); j++) {
                if (checkBulletCollisionCondition(bullets.get(i), gameObjects.get(j))) {
                    if (gameObjects.get(j) instanceof Attackable) {
                        ((Attackable) gameObjects.get(j)).getDamage(((Bullet) bullets.get(i)).getBulletDamage());
                        System.out.println("Attackable object strength = " + gameObjects.get(j).getStrength());
                        bullets.get(i).setDestroyIt(true);
                        if (gameObjects.get(j).getStrength() <= 0) {
                            if (gameObjects.get(j) instanceof HeroTank) endGame(ScreenState.HERO_LOSE);
                            gameObjects.get(j).setDestroyIt(true);
                        }
                    } else if (gameObjects.get(j) instanceof Indestructible) {
                        bullets.get(i).setDestroyIt(true);
                    }
                }
            }
        }
    }

    private void checkCollisionTanksWithObjects(List<GameObject> tanks, List<GameObject> gameObjects) {

        for (GameObject t : tanks) {
            Tank tank = (Tank) t;

            for (int i = 0; i < gameObjects.size(); i++) {

                // flags
                if ((tank instanceof HeroTank && gameObjects.get(i) instanceof EnemyFlag) &&
                        (compareCoordinates(tank, gameObjects.get(i), gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight()))) {
                    ((Flag) gameObjects.get(i)).setCaptured(true);
                    gameObjects.get(i).setDestroyIt(true);
                    destroyGameObjects(flags);
                    flagCount++;
                    i--;
                    checkWin();
                }
                if ((tank instanceof EnemyTank && gameObjects.get(i) instanceof HeroFlag) &&
                        (compareCoordinates(tank, gameObjects.get(i), gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight()))) {
                    ((Flag) gameObjects.get(i)).setCaptured(true);
                    flagCount = 0;
                    endGame(ScreenState.HERO_LOSE);
                }

                // bonus boxes
                if ((gameObjects.get(i) instanceof BonusBox) &&
                        (compareCoordinates(tank, gameObjects.get(i), gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight()))) {
                    useBonusBox(tank, gameObjects.get(i));
                    gameObjects.get(i).setDestroyIt(true);
                }

                // impassable objects
                if ((gameObjects.get(i) instanceof Impassable) &&
                        (compareCoordinates(tank, gameObjects.get(i), gameObjects.get(i).getWidth(), gameObjects.get(i).getHeight()))) {
                    if (tank == gameObjects.get(i)) continue;

                    if (gameObjects.get(i) instanceof EnemyTank) {
                        ((Tank) gameObjects.get(i)).isStop = true;
                        ((Tank) gameObjects.get(i)).isCollision = true;
                        tank.isStop = true;
                        tank.isCollision = true;
                        tank.setStopPosition();

                        if (tank instanceof EnemyTank) {
                            tank.setNewDirection();
                            tank.updateCoordinates(tank.setNewDirection(), tank, tank.speed);
                        }
                    } else {
                        tank.isStop = true;
                        tank.isCollision = true;
                        tank.setCollisionPosition(gameObjects.get(i));
                        tank.update(window.key);
                    }
                }
            }
        }
    }

    private void useBonusBox(Tank tank, GameObject bonusBox) {
        if (bonusBox instanceof SimpleBulletBox) {
            tank.addBulletsAmount(((SimpleBulletBox) bonusBox).getAmount(), TypeBullet.SIMPLE);
        } else
        if (bonusBox instanceof FastBulletBox) {
            tank.addBulletsAmount(((FastBulletBox) bonusBox).getAmount(), TypeBullet.FAST);
        } else
        if (bonusBox instanceof PowerBulletBox) {
            tank.addBulletsAmount(((PowerBulletBox) bonusBox).getAmount(), TypeBullet.POWER);
        } else
        if (bonusBox instanceof HealthBox) {
            tank.strength += ((HealthBox) bonusBox).getAmount();
            if (tank.strength > tank.maxStrength) tank.strength = tank.maxStrength;
        } else {
            throw new RuntimeException("From useBonusBox in Controller: unknown box: " + bonusBox);
        }
    }

    private boolean compareCoordinates(Tank tank, GameObject fieldObject, int objectWidth, int objectHeight) {
        return ((tank.getY() < fieldObject.getY() + objectHeight &&
                 tank.getY() + tank.getHeight() > fieldObject.getY() &&
                 tank.getX() > fieldObject.getX() - tank.getWidth() &&
                 tank.getX() < fieldObject.getX() + objectWidth) ||
                (tank.getY() + tank.getHeight() > fieldObject.getY() &&
                 tank.getY() < fieldObject.getY() + objectHeight &&
                 tank.getX() > fieldObject.getX() - tank.getWidth() &&
                 tank.getX() < fieldObject.getX() + objectWidth) ||
                (tank.getX() < fieldObject.getX() + objectWidth &&
                 tank.getX() + tank.getWidth() > fieldObject.getX() &&
                 tank.getY() > fieldObject.getY() - tank.getHeight() &&
                 tank.getY() < fieldObject.getY() + objectHeight) ||
                (tank.getX() + tank.getWidth() > fieldObject.getX() &&
                 tank.getX() < fieldObject.getX() + objectWidth &&
                 tank.getY() > fieldObject.getY() - tank.getHeight() &&
                 tank.getY() < fieldObject.getY() + objectHeight));
    }

    private void checkCollisionBulletWithBullet(List<GameObject> gameObjects) {
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = 0; j < gameObjects.size(); j++) {
                if (j == i) continue;
                if (checkBulletCollisionCondition(gameObjects.get(i), gameObjects.get(j))) {
                    if (gameObjects.get(i) instanceof Bullet) {
                        gameObjects.get(i).setDestroyIt(true);
                        gameObjects.get(j).setDestroyIt(true);
                    }
                }
            }
        }
    }

    private boolean checkBulletCollisionCondition(GameObject one, GameObject two) {
        return one.getX() >= two.getX() && one.getY() >= two.getY() &&
                one.getX() <= two.getX() + two.getWidth() &&
                one.getY() <= two.getY() + two.getHeight();
    }

    private void destroyGameObjects(List<GameObject> gameObjects) {
        gameObjects.removeIf(GameObject::getDestroyIt);
    }

    public void endGame(ScreenState state) {
        if (state == ScreenState.HERO_WIN) {
            updSessionProgress();
            if (sessionProgress == SessionProgress.STAGE_TWO) {
                window.updContainer(ScreenState.HERO_WIN_STAGE_ONE);
            } else if (sessionProgress == SessionProgress.STAGE_THREE) {
                window.updContainer(ScreenState.HERO_WIN_STAGE_TWO);
            } else if (sessionProgress == SessionProgress.STAGE_FOUR) {
                window.updContainer(ScreenState.HERO_WIN_STAGE_THREE);
            } else {
                throw new RuntimeException("From Stage.endGame: unknown session progress: " + getSessionProgress());
            }
        }
        if (state == ScreenState.HERO_LOSE) {
            sessionProgress = SessionProgress.STAGE_ONE;
            typeTank = TypeTank.SIMPLE;
            stage.getTimer().stop();
            window.updContainer(ScreenState.END);
        }
    }

    public void updSessionProgress() {
        System.out.println(state);
        System.out.println(sessionProgress);
        if (sessionProgress == SessionProgress.STAGE_FOUR) {
            sessionProgress = SessionProgress.STAGE_FOUR;
            stage.getTimer().stop();
        } else if (sessionProgress == SessionProgress.STAGE_THREE) {
            sessionProgress = SessionProgress.STAGE_FOUR;
            stage.getTimer().stop();
        } else if (sessionProgress == SessionProgress.STAGE_TWO) {
            stage.getTimer().stop();
            sessionProgress = SessionProgress.STAGE_THREE;
        } else if (sessionProgress == SessionProgress.STAGE_ONE) {
            stage.getTimer().stop();
            sessionProgress = SessionProgress.STAGE_TWO;
        } else {
            throw new RuntimeException("From Controller.updSessionProgress: unknown state");
        }
    }

    private void checkWin() {
        if (flagCount == 2) {
            flagCount = 0;
            endGame(ScreenState.HERO_WIN);
        }
    }

    public SessionProgress getSessionProgress() {
        return sessionProgress;
    }

    public void setTypeTank(TypeTank typeTank) {
        this.typeTank = typeTank;
    }

    public TypeTank getTypeTank() {
        return typeTank;
    }

    @Override
    public void update(List<GameObject> bullets, List<GameObject> field,
                       List<GameObject> tanks, List<GameObject> flags) {

        this.flags = flags;
        updateMovableObjects(tanks);
        updateMovableObjects(bullets);

        checkBulletCollision(bullets, field);
        checkBulletCollision(bullets, tanks);

        checkCollisionTanksWithObjects(tanks, flags);
        checkCollisionTanksWithObjects(tanks, field);
        checkCollisionTanksWithObjects(tanks, tanks);
        checkCollisionBulletWithBullet(bullets);

        destroyGameObjects(field);
        destroyGameObjects(tanks);
        destroyGameObjects(bullets);

    }

    @Override
    public void render(Graphics g, List<GameObject> field, List<GameObject> bullets,
                       List<GameObject> tanks, List<GameObject> flags) {
        for (GameObject object : field) object.render(g, stage);
        for (GameObject bullet : bullets) bullet.render(g, stage);
        for (GameObject tank : tanks) tank.render(g, stage);
        for (GameObject flag : flags) flag.render(g, stage);
    }
}
