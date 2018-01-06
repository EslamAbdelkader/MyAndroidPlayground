package com.example.eslam.myplayground;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.eslam.myplayground.custom.Circle;
import com.example.eslam.myplayground.custom.CircleAngleAnimation;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity);

        //Java Code
//        RotateAnimation rotateAnimation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        rotateAnimation.setDuration(6000);
//        rotateAnimation.setRepeatCount(Animation.INFINITE);
//        rotateAnimation.setInterpolator(new BounceInterpolator());

        //XML
        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        rotate.setInterpolator(new LinearInterpolator());
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.startAnimation(rotate);

        AnimatorSet fade = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fade);
        View view = findViewById(R.id.view);
        fade.setTarget(view);
        fade.start();

        final Circle circle = (Circle) findViewById(R.id.myCircle);
        circle.setAngle(200);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setInterpolator(new LinearInterpolator());

        circle.startAnimation(rotate);
//        imageView.startAnimation(rotateAnimation);

        findViewById(R.id.circlePlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, (int) (circle.getAngle() + 50));
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });

        findViewById(R.id.circleMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, (int) (circle.getAngle() - 50));
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });


        findViewById(R.id.circleZero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 0, 23);
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });


        findViewById(R.id.circleQuarter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 1, 4);
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });


        findViewById(R.id.circleHalf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 50, 100);
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });


        findViewById(R.id.circleFull).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircleAngleAnimation animation = new CircleAngleAnimation(circle, 20, 20);
                animation.setDuration(1000);
                circle.startAnimation(animation);
            }
        });

    }

}
