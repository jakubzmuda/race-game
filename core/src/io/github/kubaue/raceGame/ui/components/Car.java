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
        carImage = new Texture(Gdx.files.internal("car.png"));

        carShape = new Rectangle();
        carShape.x = GameViewport.width() / 2f - 64 / 2f;
        carShape.y = 20;
        carShape.width = 64;
        carShape.height = 64;
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
        if (carShape.x < 0)
            carShape.x = 0;
        if (carShape.x > GameViewport.width() - 64)
            carShape.x = GameViewport.width() - 64;
    }

    @Override
    public void dispose() {
        carImage.dispose();
    }
}
