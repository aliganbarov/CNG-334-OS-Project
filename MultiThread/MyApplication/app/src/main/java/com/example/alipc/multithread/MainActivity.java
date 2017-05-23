package com.example.alipc.multithread;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Sensor pressureSensor;
    private HandlerThread pressureSensorThread;
    private Handler pressureSensorHandler;
    private SensorManager pressureSensorManager;

    private Sensor gameRotationVectorSensor;
    private HandlerThread gameRotationVectorSensorThread;
    private Handler gameRotationVectorSensorHandler;
    private SensorManager gameRotationSensorManager;

    private Sensor linearAccelerationSensor;
    private HandlerThread linearAccelerationSensorThread;
    private Handler linearAccelerationSensorHandler;
    private SensorManager linearAccelerationSensorManager;

    private Sensor stepCounterSensor;
    private HandlerThread stepConterSensorThread;
    private Handler stepCounterSensorHandler;
    private SensorManager stepCounterSensorManager;

    //private SensorManager sensorManager;

    private LocationManager locationManager1;
    private LocationListener locationListener1;
    private HandlerThread locationHandlerThread1;
    private Looper looper1;

    private LocationManager locationManager2;
    private LocationListener2 locationListener2;
    private HandlerThread locationHandlerThread2;
    private Looper looper2;



    private LocationManager locationManager3;
    private LocationListener3 locationListener3;
    private HandlerThread locationHandlerThread3;
    private Looper looper3;

    private LocationManager locationManager4;
    private LocationListener4 locationListener4;
    private HandlerThread locationHandlerThread4;
    private Looper looper4;

    private LocationManager locationManager5;
    private LocationListener5 locationListener5;
    private HandlerThread locationHandlerThread5;
    private Looper looper5;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register pressure sensor
        pressureSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        pressureSensor = pressureSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        pressureSensorThread = new HandlerThread("Pressure Sensor Thread");
        pressureSensorThread.start();
        pressureSensorHandler = new Handler(pressureSensorThread.getLooper());
        pressureSensorManager.registerListener(new PressureSensorListener(), pressureSensor, 1, pressureSensorHandler);

        // register game rotation vector sensor
        gameRotationSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gameRotationVectorSensor = gameRotationSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        gameRotationVectorSensorThread = new HandlerThread("GRV Sensor Thread");
        gameRotationVectorSensorThread.start();
        gameRotationVectorSensorHandler = new Handler(gameRotationVectorSensorThread.getLooper());
        gameRotationSensorManager.registerListener(new GameRotationVectorSensorListener(), gameRotationVectorSensor, 1, gameRotationVectorSensorHandler);

        // register linear acceleration sensor
        linearAccelerationSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        linearAccelerationSensor = linearAccelerationSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        linearAccelerationSensorThread = new HandlerThread("Linear Acceleration Thread");
        linearAccelerationSensorThread.start();
        linearAccelerationSensorHandler = new Handler(linearAccelerationSensorThread.getLooper());
        linearAccelerationSensorManager.registerListener(new LinearAccelerationSensorListener(), linearAccelerationSensor, 1, linearAccelerationSensorHandler);

        // register step counter sensor
        stepCounterSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        stepCounterSensor = stepCounterSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        stepConterSensorThread = new HandlerThread("Step Counter Thread");
        stepConterSensorThread.start();
        stepCounterSensorHandler = new Handler(stepConterSensorThread.getLooper());
        stepCounterSensorManager.registerListener(new StepCounterListener(), stepCounterSensor, 1, stepCounterSensorHandler);


        //get user permission for gps
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);


        // register location sensors
        locationManager1 = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener1 = new LocationListener();
        locationHandlerThread1 = new HandlerThread("Location Handler", Thread.MAX_PRIORITY);
        locationHandlerThread1.start();
        looper1 = locationHandlerThread1.getLooper();

        locationManager2 = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener2= new LocationListener2();
        locationHandlerThread2 = new HandlerThread("Location Handler 2");
        looper2 = locationHandlerThread2.getLooper();

        locationManager3 = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener3 = new LocationListener3();
        locationHandlerThread3 = new HandlerThread("Location Handler 3");
        looper3 = locationHandlerThread3.getLooper();

        locationManager4 = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener4 = new LocationListener4();
        locationHandlerThread4 = new HandlerThread("Location Handler 4");
        looper4 = locationHandlerThread4.getLooper();

        locationManager5 = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener5 = new LocationListener5();
        locationHandlerThread5 = new HandlerThread("Location Handler 5");
        looper5 = locationHandlerThread3.getLooper();


        try {
            locationManager1.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener1, looper1);
            locationManager2.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener2, looper2);
            locationManager3.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener3, looper3);
            locationManager4.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener4, looper4);
            locationManager5.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener5, looper5);

        } catch (SecurityException e) {
            e.printStackTrace();
        }


    }
}
