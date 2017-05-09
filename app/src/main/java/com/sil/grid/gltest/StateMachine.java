package com.sil.grid.gltest;

import com.sil.grid.gltest.models.State;

/**
 * Created by Marik on 08.05.2017.
 */

public class StateMachine {
    private State state;

    public StateMachine() {
        state = State.ALARM_DISARMED_ALL_UNLOCKED;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
