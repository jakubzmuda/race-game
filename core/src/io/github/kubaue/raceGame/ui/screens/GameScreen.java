package io.github.kubaue.raceGame.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.engine.GameEngine;
import io.github.kubaue.raceGame.ui.GameViewport;
import io.github.kubaue.raceGame.ui.InputProcessor;
import io.github.kubaue.raceGame.ui.components.CarComponent;
import io.github.kubaue.raceGame.ui.components.Component;
import io.github.kubaue.raceGame.ui.components.LapTimeComponent;
import io.github.kubaue.raceGame.ui.components.TrackComponent;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private OrthographicCamera camera;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private GameViewport gameViewport;
    private GameEngine gameEngine = new GameEngine();
    private InputProcessor inputProcessor = new InputProcessor();

    private List<Component> components = new ArrayList<>();

    public GameScreen() {
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameViewport.width(), GameViewport.height());
        gameViewport = new GameViewport(camera);

        components.add(new TrackComponent(font, spriteBatch, gameEngine));
        components.add(new CarComponent(font, spriteBatch, gameEngine));
        components.add(new LapTimeComponent(font, spriteBatch, gameEngine));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        this.gameEngine = gameEngine.nextTick(inputProcessor.actionsFromInput());

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        for (Component component : components) {
            component.render(gameEngine);
        }
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
