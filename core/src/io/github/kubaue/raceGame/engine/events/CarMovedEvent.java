package io.github.kubaue.raceGame.engine.events;

import com.badlogic.gdx.math.Vector2;

public class CarMovedEvent implements GameEvent {

    private Vector2 position;

    @Override
    public GameEventType type() {
        return GameEventType.CAR_MOVED;
    }

    public CarMovedEvent(Vector2 position) {
        this.position = position;
    }

    public Vector2 position() {
        return position;
    }
}
