package game_objects.tanks;

import game_objects.*;
import game_objects.ammo.*;
import window.ImageManager;
import window.panels.Stage;

import java.awt.*;
import java.util.Random;

public abstract class Tank extends GameObject implements Movable, Attackable, Impassable {

    private TypeTank typeTank;
    public int prevX;
    public int prevY;
    public int speed;
    public int maxStrength;
    int reloadClipDelay;
    int reloadBulletDelay;
    int clipVolume;
    public int ammo;
    public TypeBullet typeBullet = TypeBullet.EMPTY;
    public int simpleBulletsAmount;
    public int fastBulletsAmount;
    public int powerBulletsAmount;
    public int maxSimpleBulletsAmount;
    public int maxFastBulletsAmount;
    public int maxPowerBulletsAmount;
    public long startTimeReloadDelay;
    public boolean isStop = true;
    public boolean isCollision;
    public Boolean isReady = true;
    public Boolean isReloaded = true;
    Direction direction = Direction.UP;
    Stage stage;

    public Tank(Stage stage, TypeTank typeTank, int x, int y) {
        this.stage = stage;
        this.typeTank = typeTank;
        this.x = x;
        this.y = y;
        width = 38;
        height = 38;
    }

    void shoot(Direction direction) {
        if (typeTank == TypeTank.SUPER && ammo == 1) ammo = 2;
        this.direction = direction;
        if (ammo > 0 && isReady && isReloaded) {
            isReady = false;
            startTimeReloadDelay = System.currentTimeMillis(); // нужно для отрисовки

            if (typeBullet == TypeBullet.SIMPLE) {
                if (typeTank == TypeTank.SUPER || this instanceof SuperEnemyTank) {
                    stage.bullets.add(new SimpleBullet(setBulletX(width / 2 - 15), setBulletY(width / 2 - 15), direction));
                    stage.bullets.add(new SimpleBullet(setBulletX(width / 2 - 24), setBulletY(width / 2 - 24), direction));
                } else {
                    stage.bullets.add(new SimpleBullet(setBulletX(0), setBulletY(0), direction));
                }
            } else if (typeBullet == TypeBullet.FAST) {
                if (typeTank == TypeTank.SUPER || this instanceof SuperEnemyTank) {
                    stage.bullets.add(new FastBullet(setBulletX(width / 2 - 15), setBulletY(width / 2 - 15), direction));
                    stage.bullets.add(new FastBullet(setBulletX(width / 2 - 24), setBulletY(width / 2 - 24), direction));
                } else {
                    stage.bullets.add(new FastBullet(setBulletX(0), setBulletY(0), direction));
                }
            } else if (typeBullet == TypeBullet.POWER) {
                if (typeTank == TypeTank.SUPER || this instanceof SuperEnemyTank) {
                    stage.bullets.add(new PowerBulletForSuperTank(setBulletX(width / 2 - 15), setBulletY(width / 2 - 15), direction));
                    stage.bullets.add(new PowerBulletForSuperTank(setBulletX(width / 2 - 24), setBulletY(width / 2 - 24), direction));
                } else {
                    stage.bullets.add(new PowerBullet(setBulletX(0), setBulletY(0), direction));
                }
            } else {
                System.out.println("Trouble in method Tank.shoot()");
            }
            if (typeTank == TypeTank.SUPER) {
                ammo -= 2;
                if (ammo < 0) ammo = 0;
            } else {
                ammo--;
            }
            reloadDelay(reloadBulletDelay, isReady);
        }
    }

    public void reloadDelay(int delay, Boolean whatMustHappens) {
        try {
            Thread.sleep(delay);
            if (whatMustHappens.equals(isReady)) isReady = true;
            if (whatMustHappens.equals(isReloaded)) isReloaded = true;
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    public void addBulletsAmount(int amount, TypeBullet typeBullet) {
        if (typeBullet == TypeBullet.SIMPLE)
            simpleBulletsAmount = checkMaxBulletsAmount(amount, typeBullet) ?
                    maxSimpleBulletsAmount : (simpleBulletsAmount += amount);
        if (typeBullet == TypeBullet.FAST)
            fastBulletsAmount = checkMaxBulletsAmount(amount, typeBullet) ?
                    maxFastBulletsAmount : (fastBulletsAmount += amount);
        if (typeBullet == TypeBullet.POWER)
            powerBulletsAmount = checkMaxBulletsAmount(amount, typeBullet) ?
                    maxPowerBulletsAmount : (powerBulletsAmount += amount);
    }

    private boolean checkMaxBulletsAmount(int amount, TypeBullet typeBullet) {
        if (typeBullet == TypeBullet.SIMPLE) return (amount + simpleBulletsAmount) > maxSimpleBulletsAmount;
        if (typeBullet == TypeBullet.FAST) return (amount + fastBulletsAmount) > maxFastBulletsAmount;
        if (typeBullet == TypeBullet.POWER) return (amount + powerBulletsAmount) > maxPowerBulletsAmount;
        throw new RuntimeException("From Tank.checkMaxBulletsAmount: unknown bullet type: " + typeBullet);
    }

    public void setStopPosition() {
        if (direction == Direction.UP && prevY > getY()) y = prevY;
        if (direction == Direction.DOWN && prevY < getY()) y = prevY;
        if (direction == Direction.LEFT && prevX > getX()) x = prevX;
        if (direction == Direction.RIGHT && prevX < getX()) x = prevX;
    }

    public Direction setNewDirection() {
        Random random = new Random();
        Direction wrongDirection = direction;
        int d = random.nextInt(4);
        if (d == 0) direction = Direction.UP;
        if (d == 1) direction = Direction.DOWN;
        if (d == 2) direction = Direction.LEFT;
        if (d == 3) direction = Direction.RIGHT;
        if (direction == wrongDirection) setNewDirection();
        return direction;
    }

    public void setCollisionPosition(GameObject gameObject) {
        if (prevY > gameObject.getY() && direction == Direction.UP) y = gameObject.getY() + gameObject.getHeight() + speed;
        if (prevY < gameObject.getY() && direction == Direction.DOWN) y = gameObject.getY() - this.getHeight() - speed;
        if (prevX > gameObject.getX() && direction == Direction.LEFT) x = gameObject.getX() + gameObject.getWidth() + speed;
        if (prevX < gameObject.getX() && direction == Direction.RIGHT) x = gameObject.getX() - this.getWidth() - speed;
    }

    int setBulletX(int adjustment) {
        int x = 0;
        if (direction == Direction.UP || direction == Direction.DOWN) x = this.x + width / 2 + adjustment;
        if (direction == Direction.RIGHT) x = this.x + width + 1;
        if (direction == Direction.LEFT) x = this.x - 1;
        return x;
    }

    int setBulletY(int adjustment) {
        int y = 0;
        if (direction == Direction.LEFT || direction == Direction.RIGHT) y = this.y + width / 2 + adjustment;
        if (direction == Direction.DOWN) y = this.y + width + 1;
        if (direction == Direction.UP) y = this.y - 1;
        return y;
    }

    public void setX(int x) {
        if (isCollision) {
            this.x = x;
            isCollision = false;
        }
    }

    public void setY(int y) {
        if (isCollision) {
            this.y = y;
            isCollision = false;
        }
    }

    @Override
    public void move() {
        if (!isStop) {
            prevX = x;
            prevY = y;
            updateCoordinates(direction, this, speed);
        }
    }

    @Override
    public void render(Graphics g, Stage stage) {
        g.drawImage(chooseSprite(direction), x, y, stage);
    }

    private Image chooseSprite(Direction direction) {

        if (direction == Direction.UP) {
            if (this instanceof HeroTank && typeTank == TypeTank.SIMPLE) return ImageManager.getUpHeroTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.FAST) return ImageManager.getUpHeroFastTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.POWER) return ImageManager.getUpHeroPowerTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.SUPER) return ImageManager.getUpHeroSuperTankSprite();
            if (this instanceof SimpleEnemyTank) return ImageManager.getUpSimpleEnemyTankSprite();
            if (this instanceof FastEnemyTank) return ImageManager.getUpFastEnemyTankSprite();
            if (this instanceof PowerEnemyTank) return ImageManager.getUpPowerEnemyTankSprite();
            if (this instanceof SuperEnemyTank) return ImageManager.getUpSuperEnemyTankSprite();
        } else if (direction == Direction.DOWN) {
            if (this instanceof HeroTank && typeTank == TypeTank.SIMPLE) return ImageManager.getDownHeroTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.FAST) return ImageManager.getDownHeroFastTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.POWER) return ImageManager.getDownHeroPowerTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.SUPER) return ImageManager.getDownHeroSuperTankSprite();
            if (this instanceof SimpleEnemyTank) return ImageManager.getDownSimpleEnemyTankSprite();
            if (this instanceof FastEnemyTank) return ImageManager.getDownFastEnemyTankSprite();
            if (this instanceof PowerEnemyTank) return ImageManager.getDownPowerEnemyTankSprite();
            if (this instanceof SuperEnemyTank) return ImageManager.getDownSuperEnemyTankSprite();
        } else if (direction == Direction.LEFT) {
            if (this instanceof HeroTank && typeTank == TypeTank.SIMPLE) return ImageManager.getLeftHeroTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.FAST) return ImageManager.getLeftHeroFastTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.POWER) return ImageManager.getLeftHeroPowerTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.SUPER) return ImageManager.getLeftHeroSuperTankSprite();
            if (this instanceof SimpleEnemyTank) return ImageManager.getLeftSimpleEnemyTankSprite();
            if (this instanceof FastEnemyTank) return ImageManager.getLeftFastEnemyTankSprite();
            if (this instanceof PowerEnemyTank) return ImageManager.getLeftPowerEnemyTankSprite();
            if (this instanceof SuperEnemyTank) return ImageManager.getLeftSuperEnemyTankSprite();
        } else if (direction == Direction.RIGHT) {
            if (this instanceof HeroTank && typeTank == TypeTank.SIMPLE) return ImageManager.getRightHeroTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.FAST) return ImageManager.getRightHeroFastTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.POWER) return ImageManager.getRightHeroPowerTankSprite();
            if (this instanceof HeroTank && typeTank == TypeTank.SUPER) return ImageManager.getRightHeroSuperTankSprite();
            if (this instanceof SimpleEnemyTank) return ImageManager.getRightSimpleEnemyTankSprite();
            if (this instanceof FastEnemyTank) return ImageManager.getRightFastEnemyTankSprite();
            if (this instanceof PowerEnemyTank) return ImageManager.getRightPowerEnemyTankSprite();
            if (this instanceof SuperEnemyTank) return ImageManager.getRightSuperEnemyTankSprite();
        }
        throw new RuntimeException("Trouble in Tank.render(): unknown direction: " + direction);
    }

    @Override
    public void getDamage(int damage) {
        strength -= damage;
    }

    public long getStartTimeReloadDelay() {
        return startTimeReloadDelay;
    }

    public int getMaxStrength() {
        return maxStrength;
    }

    public int getReloadClipDelay() {
        return reloadClipDelay;
    }

    public int getReloadBulletDelay() {
        return reloadBulletDelay;
    }

    public abstract void update(int key);

    abstract void addAmmo(TypeBullet type);
}
