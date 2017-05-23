package com.example.alipc.multithread;

import android.location.*;
import android.os.Bundle;

/**
 * Created by AliPC on 21-May-17.
 */

public class LocationListener5 implements android.location.LocationListener {

    private static int count = 0;
    public long time;

    @Override
    public void onLocationChanged(Location location) {
        time = System.currentTimeMillis();
        System.out.println("Location 5 has changed at " + time);

        LocationListener l = new LocationListener();
        long dif = time - l.time;
        System.out.println("Total time: " + dif);
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
