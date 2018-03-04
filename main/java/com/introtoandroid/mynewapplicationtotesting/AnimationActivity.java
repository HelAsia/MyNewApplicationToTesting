package com.introtoandroid.mynewapplicationtotesting;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final Button startAnimationButton = (Button) findViewById(R.id.bStartAnimation);

        startAnimationButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ImageView iv = (ImageView)findViewById(R.id.ivAnim);
                iv.setBackgroundResource(R.drawable.juggle);

                AnimationDrawable frameAnimation = (AnimationDrawable) iv.getBackground();
                frameAnimation.start();
            }
        });

        final Button stopAnimationButton = (Button) findViewById(R.id.bStopAnimation);

        stopAnimationButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ImageView iv = (ImageView)findViewById(R.id.ivAnim);
                iv.setBackgroundResource(R.drawable.juggle);

                AnimationDrawable frameAnimation = (AnimationDrawable) iv.getBackground();
                frameAnimation.stop();
            }
        });
    }
}
