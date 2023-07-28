package window.panels;

import game_objects.ammo.TypeBullet;
import game_objects.tanks.HeroTank;
import game_objects.tanks.TypeTank;
import window.ImageManager;
import game_objects.tanks.TypeReloadDelay;
import window.TypeStripe;

import javax.swing.*;
import java.awt.*;

public class HeroInfoPanel extends JPanel {

    HeroTank hero;
    private final int strengthStripeLength = 301;
    private final int reloadStripeLength = 240;
    private final int stripeHeight = 34;
    private final JTextField simpleBulletField = new JTextField();
    private final JTextField fastBulletField = new JTextField();
    private final JTextField powerBulletField = new JTextField();
    private final Font font = new Font("SansSerif", Font.PLAIN, 30);

    public HeroInfoPanel(HeroTank hero) {
        this.hero = hero;
        setBackground(Color.white);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        showStrengthStripe(g);
        showClipMark(g, hero.typeBullet);
        if (hero.isReloaded || hero.isReady) showClip(g);
        if (!hero.isReloaded) showReloadStripe(g, TypeReloadDelay.CLIP_RELOAD);
        if (hero.ammo > 0 && hero.isReloaded && !hero.isReady) showReloadStripe(g, TypeReloadDelay.BULLET_RELOAD);
        showHeroInfo(g);
        //ServiceClass.scaleCheck(g, this, 150);
    }

    private void addBulletsAmountField(JTextField field) {
        add(field);
        field.setEditable(false);
        field.setFont(font);
        field.setSize(70, 34);
    }

    private void showHeroInfo(Graphics g) {
        addBulletsAmountField(simpleBulletField);
        addBulletsAmountField(fastBulletField);
        addBulletsAmountField(powerBulletField);
        simpleBulletField.setLocation(454, 58);
        fastBulletField.setLocation(622, 58);
        powerBulletField.setLocation(790, 58);
        simpleBulletField.setText(String.valueOf(hero.simpleBulletsAmount));
        fastBulletField.setText(String.valueOf(hero.fastBulletsAmount));
        powerBulletField.setText(String.valueOf(hero.powerBulletsAmount));
        g.drawImage(ImageManager.getHeroInfoMain(), 0, 0, this);
        g.drawImage(ImageManager.getSimpleBulletImg(), 394, 58, this);
        if (hero.getTypeTank() == TypeTank.SIMPLE || hero.getTypeTank() == TypeTank.FAST) {
            g.drawImage(ImageManager.getEmptyClipImg(), 730, 58, this);
        }
        if (hero.getTypeTank() == TypeTank.POWER) {
            g.drawImage(ImageManager.getEmptyClipImg(), 562, 58, this);
        }
        if (hero.getTypeTank() == TypeTank.SIMPLE || hero.getTypeTank() == TypeTank.FAST ||
                hero.getTypeTank() == TypeTank.SUPER) {
            g.drawImage(ImageManager.getFastBulletImg(), 562, 58, this);
        }
        if (hero.getTypeTank() == TypeTank.POWER || hero.getTypeTank() == TypeTank.SUPER) {
            g.drawImage(ImageManager.getPowerBulletImg(), 730, 58, this);
        }
        g.drawImage(ImageManager.getBulletsAmountImg(), 355, 0, this);
    }

    private void showClip(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(88, 88, reloadStripeLength, stripeHeight);
        for (int i = 0; i < hero.ammo; i++) {
            g.drawImage(ImageManager.getClipUnitImg(), (i * 24 /* clip_unit width */) + 88, 88, this);
        }
    }

    private void showClipMark(Graphics g, TypeBullet typeBullet) {
        if (typeBullet == TypeBullet.EMPTY) g.drawImage(ImageManager.getEmptyClipImg(), 27, 88, this);
        if (typeBullet == TypeBullet.SIMPLE) g.drawImage(ImageManager.getSimpleBulletImg(), 27, 88, this);
        if (typeBullet == TypeBullet.FAST) g.drawImage(ImageManager.getFastBulletImg(), 27, 88, this);
        if (typeBullet == TypeBullet.POWER) g.drawImage(ImageManager.getPowerBulletImg(), 27, 88, this);
    }

    private void showStrengthStripe(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(27, 27, strengthStripeLength, stripeHeight);
        g.setColor(Color.red);
        g.fillRect(27, 27, setStripeLength(TypeStripe.HERO_STRENGTH, strengthStripeLength), stripeHeight);
    }

    private void showReloadStripe(Graphics g, TypeReloadDelay typeReloadDelay) {
        g.setColor(Color.gray);
        g.fillRect(88, 88, reloadStripeLength, stripeHeight);
        g.setColor(Color.black);
        if (typeReloadDelay == TypeReloadDelay.CLIP_RELOAD)
            g.fillRect(88, 88, setStripeLength(TypeStripe.CLIP_RELOAD, reloadStripeLength), stripeHeight);
        if (typeReloadDelay == TypeReloadDelay.BULLET_RELOAD)
            g.fillRect(88, 88, setStripeLength(TypeStripe.BULLET_RELOAD, reloadStripeLength), stripeHeight);
    }

    private int setStripeLength(TypeStripe stripe, int stripeLength) {
        if (stripe == TypeStripe.HERO_STRENGTH) {
            return (int) ((float) hero.getStrength() / (float) hero.getMaxStrength() * stripeLength);
        } else
        if (stripe == TypeStripe.CLIP_RELOAD) {
            return (int) (calculateDeltaTime() / (float) hero.getReloadClipDelay() * stripeLength);
        } else
        if (stripe == TypeStripe.BULLET_RELOAD) {
            return (int) (calculateDeltaTime() / (float) hero.getReloadBulletDelay() * stripeLength);
        } else {
            throw new RuntimeException("From 'HeroInfoPanel': unknown stripe type: " + stripe);
        }
    }

    private float calculateDeltaTime() {
        long startTime = hero.getStartTimeReloadDelay();
        long currentTime = System.currentTimeMillis();
        return (float) (currentTime - startTime);
    }
}
