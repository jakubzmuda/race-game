package io.github.kubaue.raceGame.engine;

import io.github.kubaue.raceGame.engine.events.GameEvent;
import io.github.kubaue.raceGame.engine.events.GameEventSubscriber;
import io.github.kubaue.raceGame.engine.events.GameEventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameEventQueue {

    private Map<GameEventType, List<GameEventSubscriber>> subscribers = prepareSubscribers();

    public void subscribeForEvent(GameEventType event, GameEventSubscriber subscriber) {
        subscribers.get(event).add(subscriber);
    }

    public void publishEvent(GameEvent event) {
        for (GameEventSubscriber subscriber : subscribers.get(event.type())) {
            subscriber.onGameEvent(event);
        }
    }

    private Map<GameEventType, List<GameEventSubscriber>> prepareSubscribers() {
        Map<GameEventType, List<GameEventSubscriber>> map = new HashMap<>();
        for (GameEventType eventType : GameEventType.values()) {
            map.put(eventType, new ArrayList<>());
        }
        return map;
    }
}
