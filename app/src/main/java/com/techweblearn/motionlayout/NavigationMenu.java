package com.techweblearn.motionlayout;

import android.support.constraint.motion.MotionLayout;
import android.support.constraint.utils.ImageFilterView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NavigationMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mavigation_menu);
        final MotionLayout motionLayout = findViewById(R.id.motion_root);
        ImageView button=findViewById(R.id.menu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(motionLayout.getProgress()==1)
                {
                    motionLayout.transitionToStart();
                }else motionLayout.transitionToEnd();

            }
        });
    }
}
