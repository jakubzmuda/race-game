package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.engine.GameEngine;

public abstract class Component {

    protected final BitmapFont font;
    protected final SpriteBatch spriteBatch;

    public Component(BitmapFont font, SpriteBatch spriteBatch) {
        this.font = font;
        this.spriteBatch = spriteBatch;
    }

    public abstract void render(GameEngine gameEngine);

    public abstract void dispose();
}
