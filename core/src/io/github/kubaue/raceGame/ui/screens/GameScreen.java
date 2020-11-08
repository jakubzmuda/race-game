package io.github.kubaue.raceGame.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import io.github.kubaue.raceGame.ui.GameViewport;
import io.github.kubaue.raceGame.ui.RaceGame;
import io.github.kubaue.raceGame.ui.components.Component;
import io.github.kubaue.raceGame.ui.components.LapTime;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private final RaceGame game;
    private Texture dropImage;
    private Texture bucketImage;
    private OrthographicCamera camera;
    private Rectangle bucket;
    private SpriteBatch spriteBatch;
    private BitmapFont font;
    private GameViewport gameViewport;

    private List<Component> components = new ArrayList<>();

    public GameScreen(final RaceGame gam) {
        this.game = gam;

        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(2);

        dropImage = new Texture(Gdx.files.internal("droplet.png"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameViewport.width(), GameViewport.height());
        gameViewport = new GameViewport(camera);

        bucket = new Rectangle();
        bucket.x = GameViewport.width() / 2f - 64 / 2f;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;

        components.add(new LapTime(font, spriteBatch));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bucketImage, bucket.x, bucket.y);
        components.forEach(Component::render);
        spriteBatch.end();

        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            bucket.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (bucket.x < 0)
            bucket.x = 0;
        if (bucket.x > GameViewport.width() - 64)
            bucket.x = GameViewport.width() - 64;
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
        dropImage.dispose();
        bucketImage.dispose();
    }

}
