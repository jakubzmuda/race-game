package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;

public class Track {
    public int width() {
        return 1920;
    }

    public int height() {
        return 1080;
    }

    public Vector2 startingPosition() {
        return new Vector2(430f, 889f);
    }
}
