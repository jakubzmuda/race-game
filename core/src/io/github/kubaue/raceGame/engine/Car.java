package io.github.kubaue.raceGame.engine;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import io.github.kubaue.raceGame.engine.actions.GameAction;
import io.github.kubaue.raceGame.engine.events.CarMovedEvent;

import java.util.List;

public class Car implements GameActionAware<Car> {

    private Vector2 position;
    private float rotationInDeg;
    private Vector2 speed = new Vector2();

    private final GameEventQueue eventQueue;

    public Car(GameEventQueue eventQueue, Vector2 position, float rotationInDeg) {
        this.eventQueue = eventQueue;
        this.position = centerPosition(position);
        this.rotationInDeg = rotationInDeg;
    }

    public Car(GameEventQueue eventQueue, Vector2 position, float rotationInDeg, Vector2 speed) {
        this.eventQueue = eventQueue;
        this.position = position;
        this.rotationInDeg = rotationInDeg;
        this.speed = speed;
    }

    @Override
    public Car nextTick(List<GameAction> gameActions) {
        Vector2 newAcceleration = accelerate(gameActions);
        float newRotationFactor = rotate(gameActions);
        Vector2 newSpeed = new Vector2(speed)
                .add(newAcceleration)
                .limit(8f)
                .rotateDeg(newRotationFactor);
        Vector2 newPosition = new Vector2(position).add(newSpeed);

        eventQueue.publishEvent(new CarMovedEvent(newPosition));

        return new Car(eventQueue, newPosition, rotationInDeg + newRotationFactor, newSpeed);
    }

    private float rotate(List<GameAction> gameActions) {
        float maxAngularSpeed = 2f;
        if (gameActions.contains(GameAction.TURN_LEFT)) {
            return turn(maxAngularSpeed);
        }
        if (gameActions.contains(GameAction.TURN_RIGHT)) {
            return -turn(maxAngularSpeed);
        }
        return 0;
    }

    private float turn(float maxAngularSpeed) {
        return new Vector2(speed).rotateDeg(180).interpolate(new Vector2(maxAngularSpeed, 0), 0f, Interpolation.smooth).limit(maxAngularSpeed).len();
    }

    private Vector2 accelerate(List<GameAction> gameActions) {
        if (gameActions.contains(GameAction.BRAKE)) {
            return slowDown(0.1f);
        } else if (gameActions.contains(GameAction.ACCELERATE)) {
            return new Vector2(0.05f, 0).rotateDeg(rotationInDeg);
        } else {
            return slowDown(0.05f);
        }
    }

    private Vector2 slowDown(float speedFactor) {
        if (speed.len() > speedFactor) {
            return new Vector2(speed).rotateDeg(180).setLength(Math.max(speedFactor, 0));
        } else {
            return new Vector2(speed).rotateDeg(180);
        }
    }

    private Vector2 centerPosition(Vector2 positionToCenter) {
        return new Vector2(positionToCenter.x - width() / 2f, positionToCenter.y - height() / 2f);
    }

    public Vector2 position() {
        return position;
    }

    public float rotationInDeg() {
        return rotationInDeg;
    }

    public int width() {
        return 96;
    }

    public int height() {
        return 60;
    }
}
