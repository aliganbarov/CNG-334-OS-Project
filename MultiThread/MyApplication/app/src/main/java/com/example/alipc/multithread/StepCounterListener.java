package com.example.alipc.multithread;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import java.util.EventListener;

/**
 * Created by AliPC on 22-May-17.
 */

public class StepCounterListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
        //System.out.println("Step Counter: " + event.values[0] + ". Registered at: " + System.currentTimeMillis());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
