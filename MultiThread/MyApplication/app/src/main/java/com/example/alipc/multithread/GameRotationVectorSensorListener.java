package com.example.alipc.multithread;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by AliPC on 21-May-17.
 */

public class GameRotationVectorSensorListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
        //System.out.println("Game Rotation Vector: " + event.values[0] + ". Registered at: " + System.nanoTime());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
