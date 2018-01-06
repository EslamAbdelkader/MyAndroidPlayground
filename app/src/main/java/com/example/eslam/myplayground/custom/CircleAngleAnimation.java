package com.example.eslam.myplayground.custom;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Eslam on 9/11/2017.
 */
public class CircleAngleAnimation extends Animation {

    private Circle circle;

    private float oldAngle;
    private float newAngle;

    public CircleAngleAnimation(Circle circle, int newAngle) {
        this.oldAngle = circle.getAngle();
        this.newAngle = newAngle;
        this.circle = circle;
    }

    public CircleAngleAnimation(Circle circle, int remaining, int total) {
        this(circle, remaining * 360 / total);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        circle.setAngle(angle);
        circle.requestLayout();
    }
}