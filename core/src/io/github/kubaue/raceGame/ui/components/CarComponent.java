package io.github.kubaue.raceGame.ui.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.engine.Car;
import io.github.kubaue.raceGame.engine.GameEngine;

public class CarComponent extends Component {

    private Texture carImage;
    private Sprite carSprite;
    private Car car;

    public CarComponent(BitmapFont font, SpriteBatch spriteBatch, GameEngine gameEngine) {
        super(font, spriteBatch);
        car = gameEngine.car();
        carImage = carImage();
        carSprite = prepareCarSprite(carImage, car);
        updatePosition(car.position().x, car.position().y);
    }

    @Override
    public void render(GameEngine gameEngine) {
        Car car = gameEngine.car();
        updatePosition(car.position().x, car.position().y);
        updateRotation(car.rotationInDeg());
        carSprite.draw(spriteBatch);
    }

    @Override
    public void dispose() {
        carImage.dispose();
    }

    private void updatePosition(float x, float y) {
        carSprite.setPosition(x - car.width() / 2f, y - car.height() / 2f);
    }

    private void updateRotation(float rotationInDeg) {
        carSprite.setRotation(rotationInDeg);
    }

    private Sprite prepareCarSprite(Texture carImage, Car car) {
        return new Sprite(carImage, 0, 0, car.width(), car.height());
    }

    private Texture carImage() {
        return new Texture(Gdx.files.internal("carSlim.png"));
    }
}
