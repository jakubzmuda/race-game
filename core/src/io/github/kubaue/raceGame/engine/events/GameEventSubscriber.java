package io.github.kubaue.raceGame.engine.events;

public interface GameEventSubscriber {

    void onGameEvent(GameEvent gameEvent);

}
