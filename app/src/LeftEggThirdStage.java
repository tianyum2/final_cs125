package com.example.a2.myapplication;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class LeftEggThirdStage extends AppCompatActivity {
    ImageView b13, co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_egg_third_stage);
        b13 = (ImageView) findViewById(R.id.b13);
        AnimationDrawable basic13 = (AnimationDrawable) b13.getDrawable();
        basic13.start();
        co = (ImageView) findViewById(R.id.co);
        AnimationDrawable co23 = (AnimationDrawable) co.getDrawable();
        co23.start();
    }
}
