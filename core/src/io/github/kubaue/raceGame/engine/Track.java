package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.events.*;

public class Track implements GameEventSubscriber {

    private static TrackImage trackImage = new TrackImage();
    private GameEventQueue eventQueue;

    public Track(GameEventQueue eventQueue) {
        this.eventQueue = eventQueue;
        eventQueue.subscribeForEvent(GameEventType.CAR_MOVED, this);
    }

    @Override
    public void onGameEvent(GameEvent gameEvent) {
        if (gameEvent.type().equals(GameEventType.CAR_MOVED)) {
            CarMovedEvent event = (CarMovedEvent) gameEvent;
            if (!trackImage.isWithinTrackLimits(event.position())) {
                eventQueue.publishEvent(new CollisionDetectedEvent());
            }
        }
    }


    public int width() {
        return trackImage.width();
    }

    public int height() {
        return trackImage.height();
    }

    public Vector2 startingPosition() {
        return new Vector2(430f, 889f);
    }

    public String fileName() {
        return trackImage.fileName();
    }
}
