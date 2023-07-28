package window.panels;

import window.buttons.SampleButtonPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MarkPanel extends JPanel {

    private BufferedImage image;

    public MarkPanel() {
        this.image = image;
        setSize(40, 46);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

