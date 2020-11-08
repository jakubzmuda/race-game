package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import io.github.kubaue.raceGame.ui.GameViewport;

public class Car extends Component {

    private Texture carImage;
    private Rectangle carShape;

    public Car(BitmapFont font, SpriteBatch spriteBatch) {
        super(font, spriteBatch);
        carImage = new Texture(Gdx.files.internal("carSlim.png"));

        int width = 128;
        int height = 80;

        carShape = new Rectangle();
        carShape.x = GameViewport.width() / 2f - width / 2f;
        carShape.y = GameViewport.height() / 2f - height / 2f;
        carShape.width = width;
        carShape.height = height;
    }

    @Override
    public void render() {
        spriteBatch.draw(carImage, carShape.x, carShape.y);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carShape.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carShape.x += 200 * Gdx.graphics.getDeltaTime();
        }
    }

    @Override
    public void dispose() {
        carImage.dispose();
    }
}
