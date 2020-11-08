package io.github.kubaue.raceGame.ui;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameViewport {

    private Viewport viewport;

    public GameViewport(Camera camera) {
        viewport = new FitViewport(width(), height(), camera);
    }

    public void update(int width, int height) {
        viewport.update(width, height);
    }

    public static int width() {
        return 1920;
    }

    public static int height() {
        return 1080;
    }
}
