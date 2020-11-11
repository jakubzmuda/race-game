package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.actions.GameAction;

import java.util.List;

public class GameEngine {

    private LapTime lapTime = new LapTime();
    private Track track = new Track();
    private Car car;

    public GameEngine() {
        car = new Car(new Vector2(track.startingPosition().x, track.startingPosition().y), 0);
    }

    public GameEngine(LapTime lapTime, Car car) {
        this();
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

    public Track track() {
        return track;
    }
}
