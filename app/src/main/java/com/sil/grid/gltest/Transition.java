package com.sil.grid.gltest;

import com.sil.grid.gltest.models.Action;
import com.sil.grid.gltest.models.State;

import java.util.Map;

/**
 * Created by Marik on 08.05.2017.
 */

public class Transition {
    private Map<String, Map<String, String>> transitionMap;

    public Transition(Map<String, Map<String, String>> map) {
        transitionMap = map;
    }

    public State doTransition(Action action, State startState) {
        return State.valueOf(transitionMap.get(action.toString()).get(startState.toString()));
    }
}
