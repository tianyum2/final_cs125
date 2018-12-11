package com.example.a2.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class RightEggThirdStage extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "RightEggThirdStage";

    private SensorManager sensorManager;
    Sensor Acc;

    ImageView b23, co;
    MediaPlayer song1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_egg_third_stage);
        b23 = (ImageView) findViewById(R.id.b23);
        AnimationDrawable basic23 = (AnimationDrawable) b23.getDrawable();
        basic23.start();
        co = (ImageView) findViewById(R.id.co);
        AnimationDrawable co23 = (AnimationDrawable) co.getDrawable();
        co23.start();

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(RightEggThirdStage.this, Acc, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered gyroscope listener");


    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int i){

    }
    private boolean s = true;
    @Override
    public void onSensorChanged(SensorEvent event) {

        co = (ImageView) findViewById(R.id.co);
        if (Math.abs(event.values[0] + event.values[1] + event.values[2]) > 20 && s) {
            song1 = MediaPlayer.create(RightEggThirdStage.this, R.raw.dr_dre);
            song1.start();
            b23.setImageResource(R.drawable.m23);
            co.setImageResource(R.drawable.surprise);
            s = false;
        }
        Log.d(TAG, "onSensorChanged: X:" + event.values[0] + " Y:" + event.values[1] + " Z:" + event.values[2]);
    }
}
