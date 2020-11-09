package io.github.kubaue.raceGame.engine;

import java.util.Date;

public class LapTime {

    private Date lapStartTime = new Date();

    public long milliseconds() {
        return new Date().getTime() - lapStartTime.getTime();
    }

}
