package com.example.alipc.singlethread;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.util.TimeUnit;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mPressure;
    private Sensor mGameRotationVector;
    private Sensor mLinearAcceleration;
    private Sensor mStepCounter;

    LocationManager locationManager;

    LocationListener locationListener1;
    LocationListener locationListener2;
    LocationListener locationListener3;
    LocationListener locationListener4;
    LocationListener locationListener5;

    double totalLong = 0;
    double totalLat = 0;

    double avgLong = 0;
    double avgLat = 0;

    private long loc1Time;
    private long loc5Time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mGameRotationVector = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        mLinearAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        mStepCounter = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);


        //get access to location services of phone
        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        implementListeners();

        // For SDK < 23 no need for permission
        if (Build.VERSION.SDK_INT < 23) {
            // set location listeners
            setLocationListeners();
        } else {
            //check if permission is not granted, ask for permission from user
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // ask for permission
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                //in case we already have permission
                //set location listeners
                setLocationListeners();
            }
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        float millibars_of_pressure = event.values[0];
        //System.out.println("Pressure: " + event.values[0] + ". At time: " + System.nanoTime());
        //System.out.println("Game Rotation Vector: " + event.values[1] + ". At time: " + System.nanoTime());
        //System.out.println("Linear Acceleration: " + event.values[2] + ". At time: " + System.nanoTime());

        //System.out.println("Step Counter: " + event.values[3] + ". At time: " + System.nanoTime());
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGameRotationVector, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mLinearAcceleration, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // if request was given for location
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setLocationListeners();
            }
        }
    }

    private void setLocationListeners() {
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener1);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener2);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener3);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener4);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener5);
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    private void implementListeners() {
        // implement location listener 1
        locationListener1 = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                totalLat += location.getLatitude();
                totalLong += location.getLongitude();
                loc1Time = System.currentTimeMillis();
                System.out.println("Location Listener 1: " + loc1Time);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                // if gps is not working display 0
                totalLat += 0;
                totalLong += 0;
            }
        };

        // implement location listener 2
        locationListener2 = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                totalLat += location.getLatitude();
                totalLong += location.getLongitude();
                System.out.println("Location Listener 2: " + System.currentTimeMillis());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                // if gps is not working display 0
                totalLat += 0;
                totalLong += 0;
            }
        };

        // implement location listener 3
        locationListener3 = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                totalLat += location.getLatitude();
                totalLong += location.getLongitude();
                System.out.println("Location Listener 3: " + System.currentTimeMillis());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                // if gps is not working display 0
                totalLat += 0;
                totalLong += 0;
            }
        };

        // implement location listener 4
        locationListener4 = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                totalLat += location.getLatitude();
                totalLong += location.getLongitude();
                System.out.println("Location Listener 4: " + System.currentTimeMillis());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                // if gps is not working display 0
                totalLat += 0;
                totalLong += 0;
            }
        };

        // implement location listener 5
        locationListener5 = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                totalLat += location.getLatitude();
                totalLong += location.getLongitude();
                loc5Time = System.currentTimeMillis();
                System.out.println("Location Listener 5: " + loc5Time);
                System.out.println("Total Time: " + (loc5Time - loc1Time));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                // if gps is not working display 0
                totalLat += 0;
                totalLong += 0;
            }
        };
    }
}
