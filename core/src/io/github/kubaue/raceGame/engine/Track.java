package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;

public class Track {

    private static TrackImage trackImage = new TrackImage();

    public int width() {
        return trackImage.width();
    }

    public int height() {
        return trackImage.height();
    }

    public Vector2 startingPosition() {
        return new Vector2(430f, 889f);
    }

    public String fileName() {
        return trackImage.fileName();
    }

}
