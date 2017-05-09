package com.sil.grid.gltest;

import android.widget.Button;
import android.widget.TextView;

import com.sil.grid.gltest.models.State;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Marik on 09.05.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class RobolectricTest {

    @org.junit.Test
    public void checkLockButton() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button lockButton = (Button) activity.findViewById(R.id.button_lock);
        TextView result = (TextView) activity.findViewById(R.id.text_view_state);

        if (result.getText().toString().equals(State.ALARM_ARMED_ALL_LOCKED.toString())) {
            lockButton.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_ARMED_ALL_LOCKED"));
        } else {
            lockButton.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_DISARMED_ALL_LOCKED"));
        }
    }

    @org.junit.Test
    public void checkLockX2Button() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button lockX2Button = (Button) activity.findViewById(R.id.button_lock_x2);
        TextView result = (TextView) activity.findViewById(R.id.text_view_state);

        lockX2Button.performClick();
        Assert.assertTrue(result.getText().toString().equals("ALARM_ARMED_ALL_LOCKED"));
    }

    @org.junit.Test
    public void checkUnlockButton() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button unlockButton = (Button) activity.findViewById(R.id.button_unlock);
        TextView result = (TextView) activity.findViewById(R.id.text_view_state);

        if (result.getText().toString().equals(State.ALARM_DISARMED_ALL_UNLOCKED.toString())) {
            unlockButton.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_DISARMED_ALL_UNLOCKED"));
        } else {
            unlockButton.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_DISARMED_DRIVER_UNLOCKED"));
        }
    }

    @org.junit.Test
    public void checkUnlockX2Button() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        Button unlockX2Button = (Button) activity.findViewById(R.id.button_unlock_x2);
        TextView result = (TextView) activity.findViewById(R.id.text_view_state);

        if (result.getText().toString().equals(State.ALARM_DISARMED_DRIVER_UNLOCKED.toString())) {
            unlockX2Button.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_DISARMED_DRIVER_UNLOCKED"));
        } else {
            unlockX2Button.performClick();
            Assert.assertTrue(result.getText().toString().equals("ALARM_DISARMED_ALL_UNLOCKED"));
        }
    }
}
