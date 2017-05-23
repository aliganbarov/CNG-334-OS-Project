package com.example.alipc.multithread;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by AliPC on 22-May-17.
 */

public class LinearAccelerationSensorListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
        //System.out.println("Linear Acceleration: " + event.values[0] + ". Registered at: " + System.currentTimeMillis());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
