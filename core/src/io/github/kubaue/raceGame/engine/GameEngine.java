package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.actions.GameAction;
import io.github.kubaue.raceGame.ui.GameViewport;

import java.util.List;

public class GameEngine {

    private LapTime lapTime = new LapTime();
    private Car car = new Car(new Vector2(GameViewport.width() / 2f, GameViewport.height() / 2f), 0);

    public GameEngine() {
    }

    public GameEngine(LapTime lapTime, Car car) {
        this.lapTime = lapTime;
        this.car = car;
    }

    public GameEngine nextTick(List<GameAction> gameActions) {
        return new GameEngine(lapTime, car.nextTick(gameActions));
    }

    public LapTime lapTime() {
        return lapTime;
    }

    public Car car() {
        return car;
    }
}
