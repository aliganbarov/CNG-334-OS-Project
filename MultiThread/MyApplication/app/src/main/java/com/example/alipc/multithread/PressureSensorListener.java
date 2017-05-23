package com.example.alipc.multithread;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by AliPC on 21-May-17.
 */

public class PressureSensorListener implements SensorEventListener {

    private long timeOccured;

    @Override
    public void onSensorChanged(SensorEvent event) {
        //System.out.println("Pressure: " + event.values[0] + ". Registered at: " + System.currentTimeMillis());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
