package com.sil.grid.gltest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sil.grid.gltest.models.Action;
import com.sil.grid.gltest.models.State;
import com.sil.grid.gltest.utils.FileParser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RelativeLayout mIndicator;
    private TextView mState;
    private Transition mTransition;
    private StateMachine mStateMachine = new StateMachine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIndicator = (RelativeLayout) findViewById(R.id.layout_indicator);
        mState = (TextView) findViewById(R.id.text_view_state);

        String json = FileParser.loadJsonFromFile(this);
        mTransition = new Transition(FileParser.jsonToMap(json));

        //set OnClickListener for buttons
        findViewById(R.id.button_lock).setOnClickListener(this);
        findViewById(R.id.button_lock_x2).setOnClickListener(this);
        findViewById(R.id.button_unlock).setOnClickListener(this);
        findViewById(R.id.button_unlock_x2).setOnClickListener(this);

        updateUi();
    }

    @Override
    public void onClick(View view) {
        Action action = null;
        switch (view.getId()) {
            case R.id.button_lock:
                action = Action.LOCK;
                break;
            case R.id.button_lock_x2:
                action = Action.LOCK_X2;
                break;
            case R.id.button_unlock:
                action = Action.UNLOCK;
                break;
            case R.id.button_unlock_x2:
                action = Action.UNLOCK_X2;
                break;
        }
        if (action != null) {
            mStateMachine.setState(mTransition.doTransition(action, mStateMachine.getState()));
            updateUi();
        }
    }

    private void updateUi() {
        mState.setText(mStateMachine.getState().toString());
        if (mStateMachine.getState() == State.ALARM_ARMED_ALL_LOCKED) {
            mIndicator.setBackgroundColor(Color.RED);
        } else {
            mIndicator.setBackgroundColor(Color.GREEN);
        }
    }
}
