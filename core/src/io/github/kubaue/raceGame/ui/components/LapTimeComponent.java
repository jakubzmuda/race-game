package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.ui.GameViewport;

import java.util.Date;

public class LapTimeComponent extends Component {

    private Date lapStartTime = new Date();

    public LapTimeComponent(BitmapFont font, SpriteBatch spriteBatch) {
        super(font, spriteBatch);
    }

    @Override
    public void render() {
        long lapTimeMilliseconds = Math.abs(new Date().getTime() - lapStartTime.getTime());
        font.draw(spriteBatch, "Lap time: " + lapTimeMilliseconds / 1000 + "." + (lapTimeMilliseconds % 1000) / 10, 32, GameViewport.height() - 32);
    }

    @Override
    public void dispose() {

    }
}
