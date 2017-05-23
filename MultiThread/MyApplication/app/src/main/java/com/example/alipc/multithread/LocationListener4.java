package com.example.alipc.multithread;

import android.location.*;
import android.os.Bundle;

/**
 * Created by AliPC on 21-May-17.
 */

public class LocationListener4 implements android.location.LocationListener {
    private static int count = 0;

    @Override
    public void onLocationChanged(Location location) {
        long time = System.currentTimeMillis();
        System.out.println("Location 4 has changed at " + time);
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
