package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.engine.GameEngine;
import io.github.kubaue.raceGame.ui.GameViewport;

public class LapTimeComponent extends Component {

    public LapTimeComponent(BitmapFont font, SpriteBatch spriteBatch, GameEngine gameEngine) {
        super(font, spriteBatch);
    }

    @Override
    public void render(GameEngine gameEngine) {
        long lapTimeMilliseconds = gameEngine.lapTime().milliseconds();
        font.draw(spriteBatch, "Lap time: " + lapTimeMilliseconds / 1000 + "." + (lapTimeMilliseconds % 1000) / 10, 32, GameViewport.height() - 32);
    }

    @Override
    public void dispose() {
    }
}
