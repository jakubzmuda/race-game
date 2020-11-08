package io.github.kubaue.raceGame.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.kubaue.raceGame.ui.GameViewport;
import io.github.kubaue.raceGame.ui.RaceGame;

public class MainMenuScreen implements Screen {

    private final RaceGame game;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;

    public MainMenuScreen(RaceGame raceGame) {
        this.game = raceGame;
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameViewport.width(), GameViewport.height());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        font.draw(batch, "Get ready for the race", GameViewport.width() / 2f, GameViewport.height() / 2f);
        font.draw(batch, "Tap anything to begin", GameViewport.width() / 2f, GameViewport.height() / 2f - 96);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen());
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
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
        batch.dispose();
        font.dispose();
    }
}
