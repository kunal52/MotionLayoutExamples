package com.techweblearn.motionlayout;

import android.support.constraint.motion.MotionLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.widget.ImageView;

import com.github.florent37.shapeofview.shapes.ArcView;

public class Main2Activity extends AppCompatActivity {

    public static final String TAG=Main2Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        MotionLayout motionLayout=findViewById(R.id.motion_layout);

        Log.d(TAG, "onCreate: "+motionLayout.getTransitionTimeMs());
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {
                Log.d(TAG, "onTransitionChange: "+v);

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {

            }
        });
    }
}
