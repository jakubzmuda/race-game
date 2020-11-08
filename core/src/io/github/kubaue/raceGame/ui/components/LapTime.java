package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.ui.GameViewport;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LapTime extends Component {

    private LocalDateTime lapStartTime = LocalDateTime.now();

    public LapTime(BitmapFont font, SpriteBatch spriteBatch) {
        super(font, spriteBatch);
    }

    @Override
    public void render() {
        long lapTimeMilliseconds = ChronoUnit.MILLIS.between(lapStartTime, LocalDateTime.now());
        font.draw(spriteBatch, "Lap time: " + lapTimeMilliseconds / 1000 + "." + (lapTimeMilliseconds % 1000) / 10, 32, GameViewport.height() - 32);
    }

    @Override
    public void dispose() {

    }
}
