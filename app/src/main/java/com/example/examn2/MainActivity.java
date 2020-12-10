package com.example.examn2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView sun;
    private FrameLayout sky;
    private ObjectAnimator Y;
    private ObjectAnimator skyObject;
    private int animationDuration = 5000;
    private AnimatorSet animatorSet;
    private int sun1 = Color.parseColor("#16DBF4");
    private int sun2 = Color.parseColor("#F5CFBE");
    private int sun3 = Color.parseColor("#F53E2E");
    private int sun4 = Color.parseColor("#000F40");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatorSet = new AnimatorSet();
        sun = findViewById(R.id.sun);
        sky = findViewById(R.id.sky);
        sky.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){ animate();
        }
    });
    }
    public void animate(){
        Y = ObjectAnimator.ofFloat(sun,"y", 2000f);
        Y.setDuration(animationDuration);
        AnimatorSet Y2 = new AnimatorSet();
        Y2.play(Y);
        Y2.start();
        ValueAnimator backgroundColor = ValueAnimator.ofObject(new ArgbEvaluator(), sun1, sun2, sun3, sun4);
        backgroundColor.setDuration(animationDuration-800);
        backgroundColor.addUpdateListener(animation -> sky.setBackgroundColor((Integer) backgroundColor.getAnimatedValue()));
        Y2.play(backgroundColor);
        Y2.start();


    }
}