package com.example.alipc.multithread;


import android.location.Location;
import android.os.Bundle;

public class LocationListener implements android.location.LocationListener {
    private static int count = 0;
    public static long time;

    @Override
    public void onLocationChanged(Location location) {
        time = System.currentTimeMillis();
        System.out.println("Location 1 has changed at " + time);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
