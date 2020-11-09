package io.github.kubaue.raceGame.ui;

import com.badlogic.gdx.Game;
import io.github.kubaue.raceGame.ui.screens.GameScreen;

public class RaceGame extends Game {

    public void create() {
        this.setScreen(new GameScreen());
    }

    public void render() {
        super.render();
    }

    public void dispose() {
    }

}
