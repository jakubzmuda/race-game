package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.actions.GameAction;
import io.github.kubaue.raceGame.engine.events.GameEvent;
import io.github.kubaue.raceGame.engine.events.GameEventSubscriber;
import io.github.kubaue.raceGame.engine.events.GameEventType;

import java.util.List;

public class GameEngine implements GameEventSubscriber, GameActionAware<GameEngine> {

    private GameEventQueue eventQueue = new GameEventQueue();

    private LapTime lapTime;
    private Track track;
    private Car car;

    {
        eventQueue.subscribeForEvent(GameEventType.COLLISION_DETECTED, this);
    }

    public GameEngine() {
        this.lapTime = new LapTime(eventQueue);
        this.track = new Track(eventQueue);
        car = new Car(eventQueue, new Vector2(track.startingPosition().x, track.startingPosition().y), 0);
    }

    public GameEngine(LapTime lapTime, Car car, Track track) {
        this.lapTime = lapTime;
        this.car = car;
        this.track = track;
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if (gameEvent.type().equals(GameEventType.COLLISION_DETECTED)) {
            System.out.println("collision");
        }
    }

    @Override
    public GameEngine nextTick(List<GameAction> gameActions) {
        return new GameEngine(lapTime, car.nextTick(gameActions), track);
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
