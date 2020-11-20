package io.github.kubaue.raceGame.engine;

import io.github.kubaue.raceGame.engine.actions.GameAction;

import java.util.List;

public interface GameActionAware<T> {

    T nextTick(List<GameAction> gameActions);
}
