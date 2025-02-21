package input;

import geometry.transformation.Rotation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
    private final Rotation rotation;
    private boolean rotatingLeft = false;
    private boolean rotatingRight = false;
    private boolean rotatingUp = false;
    private boolean rotatingDown = false;

    public KeyboardHandler(Rotation rotation) {
        this.rotation = rotation;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> rotatingLeft = true;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> rotatingRight = true;
            case KeyEvent.VK_UP, KeyEvent.VK_W -> rotatingUp = true;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> rotatingDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> rotatingLeft = false;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> rotatingRight = false;
            case KeyEvent.VK_UP, KeyEvent.VK_W -> rotatingUp = false;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> rotatingDown = false;
        }
    }

    public void update(double delta) {
        if (rotatingLeft) rotation.rotateY(-Rotation.ROTATION_SPEED * delta);
        if (rotatingRight) rotation.rotateY(Rotation.ROTATION_SPEED * delta);
        if (rotatingUp) rotation.rotateX(-Rotation.ROTATION_SPEED * delta);
        if (rotatingDown) rotation.rotateX(Rotation.ROTATION_SPEED * delta);
    }
}