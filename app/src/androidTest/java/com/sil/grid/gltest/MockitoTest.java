package com.sil.grid.gltest;

import android.support.test.runner.AndroidJUnit4;

import com.sil.grid.gltest.models.Action;
import com.sil.grid.gltest.models.State;
import com.sil.grid.gltest.utils.FileParser;

import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 * Created by Marik on 09.05.2017.
 */

@RunWith(AndroidJUnit4.class)
public class MockitoTest {
    private static final String JSON = "{\n" +
            "  \"LOCK\": {\n" +
            "    \"ALARM_DISARMED_ALL_UNLOCKED\": \"ALARM_DISARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_DISARMED_DRIVER_UNLOCKED\": \"ALARM_DISARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_DISARMED_ALL_LOCKED\": \"ALARM_DISARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_ARMED_ALL_LOCKED\": \"ALARM_ARMED_ALL_LOCKED\"\n" +
            "  },\n" +
            "  \"LOCK_X2\": {\n" +
            "    \"ALARM_DISARMED_ALL_UNLOCKED\": \"ALARM_ARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_DISARMED_DRIVER_UNLOCKED\": \"ALARM_ARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_DISARMED_ALL_LOCKED\": \"ALARM_ARMED_ALL_LOCKED\",\n" +
            "    \"ALARM_ARMED_ALL_LOCKED\": \"ALARM_ARMED_ALL_LOCKED\"\n" +
            "  },\n" +
            "  \"UNLOCK\": {\n" +
            "    \"ALARM_DISARMED_ALL_UNLOCKED\": \"ALARM_DISARMED_ALL_UNLOCKED\",\n" +
            "    \"ALARM_DISARMED_DRIVER_UNLOCKED\": \"ALARM_DISARMED_DRIVER_UNLOCKED\",\n" +
            "    \"ALARM_DISARMED_ALL_LOCKED\": \"ALARM_DISARMED_DRIVER_UNLOCKED\",\n" +
            "    \"ALARM_ARMED_ALL_LOCKED\": \"ALARM_DISARMED_DRIVER_UNLOCKED\"\n" +
            "  },\n" +
            "  \"UNLOCK_X2\": {\n" +
            "    \"ALARM_DISARMED_ALL_UNLOCKED\": \"ALARM_DISARMED_ALL_UNLOCKED\",\n" +
            "    \"ALARM_DISARMED_DRIVER_UNLOCKED\": \"ALARM_DISARMED_DRIVER_UNLOCKED\",\n" +
            "    \"ALARM_DISARMED_ALL_LOCKED\": \"ALARM_DISARMED_ALL_UNLOCKED\",\n" +
            "    \"ALARM_ARMED_ALL_LOCKED\": \"ALARM_DISARMED_ALL_UNLOCKED\"\n" +
            "  }\n" +
            "}";


    @org.junit.Test
    public void testLock() throws Exception {
        Transition transition = new Transition(FileParser.jsonToMap(JSON));
        Assert.assertTrue(transition.doTransition(Action.LOCK, State.ALARM_DISARMED_ALL_UNLOCKED)
                == State.ALARM_DISARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK, State.ALARM_DISARMED_DRIVER_UNLOCKED)
                == State.ALARM_DISARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK, State.ALARM_DISARMED_ALL_LOCKED)
                == State.ALARM_DISARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK, State.ALARM_ARMED_ALL_LOCKED)
                == State.ALARM_ARMED_ALL_LOCKED);
    }

    @org.junit.Test
    public void testLockX2() throws Exception {
        Transition transition = new Transition(FileParser.jsonToMap(JSON));
        Assert.assertTrue(transition.doTransition(Action.LOCK_X2, State.ALARM_DISARMED_ALL_UNLOCKED)
                == State.ALARM_ARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK_X2, State.ALARM_DISARMED_DRIVER_UNLOCKED)
                == State.ALARM_ARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK_X2, State.ALARM_DISARMED_ALL_LOCKED)
                == State.ALARM_ARMED_ALL_LOCKED);
        Assert.assertTrue(transition.doTransition(Action.LOCK_X2, State.ALARM_ARMED_ALL_LOCKED)
                == State.ALARM_ARMED_ALL_LOCKED);
    }

    @org.junit.Test
    public void testUnlock() throws Exception {
        Transition transition = new Transition(FileParser.jsonToMap(JSON));
        Assert.assertTrue(transition.doTransition(Action.UNLOCK, State.ALARM_DISARMED_ALL_UNLOCKED)
                == State.ALARM_DISARMED_ALL_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK, State.ALARM_DISARMED_DRIVER_UNLOCKED)
                == State.ALARM_DISARMED_DRIVER_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK, State.ALARM_DISARMED_ALL_LOCKED)
                == State.ALARM_DISARMED_DRIVER_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK, State.ALARM_ARMED_ALL_LOCKED)
                == State.ALARM_DISARMED_DRIVER_UNLOCKED);
    }

    @org.junit.Test
    public void testUnlockX2() throws Exception {
        Transition transition = new Transition(FileParser.jsonToMap(JSON));
        Assert.assertTrue(transition.doTransition(Action.UNLOCK_X2, State.ALARM_DISARMED_ALL_UNLOCKED)
                == State.ALARM_DISARMED_ALL_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK_X2, State.ALARM_DISARMED_DRIVER_UNLOCKED)
                == State.ALARM_DISARMED_DRIVER_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK_X2, State.ALARM_DISARMED_ALL_LOCKED)
                == State.ALARM_DISARMED_ALL_UNLOCKED);
        Assert.assertTrue(transition.doTransition(Action.UNLOCK_X2, State.ALARM_ARMED_ALL_LOCKED)
                == State.ALARM_DISARMED_ALL_UNLOCKED);
    }
}
