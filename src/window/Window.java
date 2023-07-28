package window;

import window.panels.*;
import window.panels.WinPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener {

    Container container;
    ScreenState state = ScreenState.START;
    Controller controller = new Controller(this);
    int key;
    private TypeMoveControl typeMoveControl = TypeMoveControl.LETTERS_CONTROL;

    private Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(918, 897);
        setResizable(false);
        setTitle("Tanks");
        container = this.getContentPane();
        updContainer(state);
        setLocationRelativeTo(null);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
    }

    public void updContainer(ScreenState state) {
        container.removeAll();
        switch (state) {
            case START: container.add(new StartMenuPanel(this, controller));
                break;
            case OPTIONS: container.add(new OptionsPanel(this, controller));
                break;
            case END: container.add(new EndPanel(this, controller));
                break;
            case STAGE_1: container.add(new Stage(this, controller, state));
                break;
            case STAGE_2: container.add(new Stage(this, controller, state));
                break;
            case STAGE_3: container.add(new Stage(this, controller, state));
                break;
            case STAGE_4: container.add(new Stage(this, controller, state));
                break;
            case HERO_WIN_STAGE_ONE: container.add(new WinPanel(this, controller, ScreenState.HERO_WIN_STAGE_ONE));
                break;
            case HERO_WIN_STAGE_TWO: container.add(new WinPanel(this, controller, ScreenState.HERO_WIN_STAGE_TWO));
                break;
            case HERO_WIN_STAGE_THREE: container.add(new WinPanel(this, controller, ScreenState.HERO_WIN_STAGE_THREE));
                break;
        }
        container.revalidate();
    }


    public void setState(ScreenState state) {
        this.state = state;
    }

    public void setTypeMoveControl(TypeMoveControl typeMoveControl) {
        this.typeMoveControl = typeMoveControl;
    }

    public TypeMoveControl getTypeMoveControl() {
        return typeMoveControl;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Window::new);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = KeyEvent.VK_U;
    }
}
