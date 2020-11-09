package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.actions.GameAction;

import java.util.List;

public class Car {

    private Vector2 position;
    private float rotationInDeg;
    private Vector2 speed = new Vector2();

    public Car(Vector2 position, float rotationInDeg) {
        this.position = position;
        this.rotationInDeg = rotationInDeg;
    }

    public Car(Vector2 position, float rotationInDeg, Vector2 speed) {
        this.position = position;
        this.rotationInDeg = rotationInDeg;
        this.speed = speed;
    }

    public Car nextTick(List<GameAction> gameActions) {
        Vector2 newAcceleration = accelerate(gameActions);
        Vector2 newSpeed = new Vector2(speed).add(newAcceleration);
        Vector2 newPosition = new Vector2(position).add(newSpeed);
        return new Car(newPosition, rotationInDeg, newSpeed);
    }

    private Vector2 accelerate(List<GameAction> gameActions) {
        if (gameActions.contains(GameAction.BRAKE)) {
            return slowDown(0.2f);
        } else if (gameActions.contains(GameAction.ACCELERATE)) {
            return new Vector2(0.1f, 0).rotateDeg(rotationInDeg);
        } else {
            return slowDown(0.01f);
        }
    }

    private Vector2 slowDown(float speedFactor) {
        if(speed.len() > speedFactor) {
            return new Vector2(speed).rotateDeg(180).setLength(Math.max(speedFactor, 0));
        } else {
            return new Vector2(speed).rotateDeg(180);
        }
    }

    public Vector2 position() {
        return position;
    }

    public float rotationInDeg() {
        return rotationInDeg;
    }

    public int width() {
        return 128;
    }

    public int height() {
        return 80;
    }

}
