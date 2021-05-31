package com.awesomenativemodules.RNMap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

public class RNMapView extends MapView implements OnMapReadyCallback {
    private static final String TAG = RNMapView.class.getSimpleName();

    private MapView mapView;
    private LocationManager locationManager;
    private boolean showUserLocation = false;
    private GoogleMap googleMap;
    private ThemedReactContext reactContext;

    public RNMapView(ThemedReactContext reactContext) {
        super(reactContext);

        this.reactContext = reactContext;
        mapView = new MapView(reactContext);
        mapView.onCreate(null);
        mapView.onResume();

        if (ContextCompat.checkSelfPermission(reactContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager = (LocationManager) reactContext.getSystemService(Context.LOCATION_SERVICE);
        }

        addView(mapView);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady() -- ready");
        this.googleMap = googleMap;
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(reactContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(reactContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(this.showUserLocation);
        }
    }
}
