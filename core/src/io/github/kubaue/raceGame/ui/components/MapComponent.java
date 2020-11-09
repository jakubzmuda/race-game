package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import io.github.kubaue.raceGame.engine.GameEngine;
import io.github.kubaue.raceGame.ui.GameViewport;

public class MapComponent extends Component {

    private Rectangle mapShape;
    private Texture mapTexture;

    public MapComponent(BitmapFont font, SpriteBatch spriteBatch, GameEngine gameEngine) {
        super(font, spriteBatch);

        int width = GameViewport.width();
        int height = GameViewport.height();
        mapTexture = createTexture(width, height, new Color(0, 0.2f, 0, 1));

        mapShape = new Rectangle();
        mapShape.x = 0;
        mapShape.y = 0;
        mapShape.width = width;
        mapShape.height = height;
    }

    @Override
    public void render(GameEngine gameEngine) {
        spriteBatch.draw(mapTexture, mapShape.x, mapShape.y);
    }

    @Override
    public void dispose() {
    }

    private Texture createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, width, height);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }
}
