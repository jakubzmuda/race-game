package io.github.kubaue.raceGame.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.ui.GameViewport;
import io.github.kubaue.raceGame.ui.components.Car;
import io.github.kubaue.raceGame.ui.components.Component;
import io.github.kubaue.raceGame.ui.components.LapTime;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private GameViewport gameViewport;

    private List<Component> components = new ArrayList<>();

    public GameScreen() {
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameViewport.width(), GameViewport.height());
        gameViewport = new GameViewport(camera);

        components.add(new LapTime(font, spriteBatch));
        components.add(new Car(font, spriteBatch));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        components.forEach(Component::render);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        font.dispose();
    }

}
