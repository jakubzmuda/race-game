package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;

public class Car {

    private Vector2 position;
    private Vector2 speed;
    private Vector2 acceleration;

    public Car(Vector2 position) {
        this.position = position;
    }
}
