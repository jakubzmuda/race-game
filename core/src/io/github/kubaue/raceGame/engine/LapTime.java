package io.github.kubaue.raceGame.engine;

import java.util.Date;

public class LapTime {

    private GameEventQueue eventQueue;

    private Date lapStartTime = new Date();

    public LapTime(GameEventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    public long milliseconds() {
        return new Date().getTime() - lapStartTime.getTime();
    }

}
