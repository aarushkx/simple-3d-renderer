package renderer;

import input.KeyboardHandler;
import model.Model;

public class Animation implements Runnable {
    private static final int FPS = 120;

    private final Renderer renderer;
    private final KeyboardHandler keyboardHandler;

    // FPS display
    private static int currentFps = 0;
    private int frameCount = 0;
    private long lastFpsUpdateTime = 0;

    public Animation(Model model, Renderer renderer, KeyboardHandler keyboardHandler) {
        this.renderer = renderer;
        this.keyboardHandler = keyboardHandler;
    }

    public static int getCurrentFps() {
        return currentFps;
    }

    @Override
    public void run() {
        long lastUpdateTime = System.nanoTime();
        long lastRenderTime = System.nanoTime();

        final long OPTIMAL_TIME = 1_000_000_000 / FPS;

        while (true) {
            long currentTime = System.nanoTime();

            double delta = (currentTime - lastUpdateTime) / 1_000_000_000.0;
            lastUpdateTime = currentTime;

            keyboardHandler.update(delta);

            if ((currentTime - lastRenderTime) >= OPTIMAL_TIME) {
                renderer.repaint();

                // FPS calculation
                frameCount++;
                if ((currentTime - lastFpsUpdateTime) >= 1_000_000_000) {
                    currentFps = frameCount;
                    frameCount = 0;
                    lastFpsUpdateTime = currentTime;
                }

                lastRenderTime = currentTime;
            }

            // Maintain FPS and avoid CPU overload
            try {
                long sleepTime = (lastRenderTime + OPTIMAL_TIME - System.nanoTime()) / 1_000_000;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

