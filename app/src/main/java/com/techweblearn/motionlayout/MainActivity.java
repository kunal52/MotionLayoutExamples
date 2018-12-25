package com.techweblearn.motionlayout;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String TAG=MainActivity.class.getSimpleName();
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    int startColor;
    int endColor;
    int currentColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startColor=Color.parseColor("#D81B60");
        endColor=Color.parseColor("#234567");



        final TextView textView=findViewById(R.id.test_title);


        MotionLayout motionLayout=findViewById(R.id.motion_layout);
        motionLayout.transitionToEnd();

        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                currentColor= (int) argbEvaluator.evaluate(v,startColor,endColor);
                textView.setTextColor(currentColor);
            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {

            }
        });

    }
}
