package com.example.eslam.myplayground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eslam.myplayground.custom.Clock;

public class ClockActivity extends AppCompatActivity {

    Button calcButton;
    TextView hrsTextView;
    TextView minsTextView;
    Clock myClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        calcButton = (Button) findViewById(R.id.calculateAngleButton);
        hrsTextView = (TextView) findViewById(R.id.hrsEditText);
        minsTextView = (TextView) findViewById(R.id.minsEditText);
        myClock = (Clock) findViewById(R.id.myClock);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(hrsTextView.getText()) || TextUtils.isEmpty(minsTextView.getText())) {
                    Toast.makeText(ClockActivity.this, "Please enter valid time", Toast.LENGTH_SHORT).show();
                    return;
                }
                double hr = Double.parseDouble(hrsTextView.getText().toString());
                double min = Double.parseDouble(minsTextView.getText().toString());
                calculateAngle(hr, min);
                myClock.drawClock(hr, min);
            }
        });

    }

    private void calculateAngle(double hr, double min) {
        if (hr >= 24){
            Toast.makeText(this, "Hours can't must be less than 24", Toast.LENGTH_SHORT).show();
            return;
        }
        if (min >= 60) {
            Toast.makeText(this, "Minutes must be less than 60", Toast.LENGTH_SHORT).show();
            return;
        }
        hr = (hr >= 12) ? (hr - 12) : hr;
        Toast.makeText(this, "The angle between hands are: " + String.valueOf(Math.abs(((30 * hr) + (0.5 * min)) - (6 * min))), Toast.LENGTH_SHORT).show();
    }
}
