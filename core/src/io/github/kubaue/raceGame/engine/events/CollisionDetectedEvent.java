package io.github.kubaue.raceGame.engine.events;

public class CollisionDetectedEvent implements GameEvent {

    @Override
    public GameEventType type() {
        return GameEventType.COLLISION_DETECTED;
    }
}
