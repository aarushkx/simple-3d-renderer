package main;

import input.KeyboardHandler;
import model.Model;
import model.shape.*;
import renderer.Animation;
import renderer.Renderer;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Model model = new Donut(); // Initialize to the desired shape

        Renderer renderer = new Renderer(model);
        KeyboardHandler keyboardHandler = new KeyboardHandler(model.getRotation());

        JFrame frame = new JFrame("3D Renderer");
        frame.add(renderer);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Animation animation = new Animation(model, renderer, keyboardHandler);
        Thread animationThread = new Thread(animation);
        animationThread.start();

        renderer.addKeyListener(keyboardHandler);
        renderer.setFocusable(true);
        renderer.requestFocusInWindow();
    }
}
