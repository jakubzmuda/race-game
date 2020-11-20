package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.engine.GameEngine;
import io.github.kubaue.raceGame.engine.Track;

public class TrackComponent extends Component {

    private final Track track;
    private Texture trackImage;
    private Sprite trackSprite;

    public TrackComponent(BitmapFont font, SpriteBatch spriteBatch, GameEngine gameEngine) {
        super(font, spriteBatch);
        track = gameEngine.track();
        trackImage = trackImage();
        trackSprite = prepareTrackSprite(trackImage, track);
    }

    @Override
    public void render(GameEngine gameEngine) {
        trackSprite.draw(spriteBatch);
    }

    @Override
    public void dispose() {
        trackImage.dispose();
    }

    private Sprite prepareTrackSprite(Texture image, Track track) {
        return new Sprite(image, 0, 0, track.width(), track.height());
    }

    private Texture trackImage() {
        return new Texture(Gdx.files.internal(track.fileName()));
    }

}
