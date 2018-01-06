package com.example.eslam.myplayground.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Date;

/**
 * Created by Eslam on 9/22/2017.
 */

public class Clock extends View {
    private double clockHandAngle = Math.PI * 180 / 180;
    private double minHandAngle = Math.PI * 180 / 180;
    private int startX;
    private int startY;
    private int clockHandLength = 150;
    private int minHandLength = 200;

    public Clock(Context context) {
        super(context);
        init();
    }

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setMinHandAngle(double minHandAngle) {
        minHandAngle = 180 - minHandAngle;
        minHandAngle = Math.PI * minHandAngle / 180;
        this.minHandAngle = minHandAngle;
        requestLayout();
    }

    private void init() {
        post(new Runnable() {
            @Override
            public void run() {
                startX = getWidth() / 2;
                startY = getHeight() / 2;
                drawClock(new Date().getHours(),new Date().getMinutes());
            }
        });
    }

    public void setClockHandAngle(double clockHandAngle) {
        clockHandAngle = 180 - clockHandAngle;
        clockHandAngle = Math.PI * clockHandAngle / 180;
        this.clockHandAngle = clockHandAngle;
        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setStrokeJoin(Paint.Join.ROUND);    // set the join to round you want
        paint.setStrokeCap(Paint.Cap.ROUND);      // set the paint cap to round too
        //Circle color
        paint.setColor(Color.GRAY);
        canvas.drawLine(startX, startY, (float) (startX + clockHandLength * Math.sin(clockHandAngle)), (float) (startY + clockHandLength * Math.cos(clockHandAngle)), paint);
        canvas.drawLine(startX, startY, (float) (startX + minHandLength * Math.sin(minHandAngle)), (float) (startY + minHandLength * Math.cos(minHandAngle)), paint);
    }

    public void drawClock(double hr, double min) {
        if (hr < 24 && min < 60) {
            hr = (hr >= 12) ? (hr - 12) : hr;
            double hrAngle = (30 * hr) + (0.5 * min);
            double minAngle = 6 * min;
            setClockHandAngle(hrAngle);
            setMinHandAngle(minAngle);
        }
    }
}
