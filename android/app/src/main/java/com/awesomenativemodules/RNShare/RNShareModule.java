package com.awesomenativemodules.RNShare;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class RNShareModule extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "RNShare";

    public static final int SHARE_REQUEST_CODE = 16845; 
    
    protected final ReactApplicationContext reactContext;
    
    public RNShareModule(ReactApplicationContext reactContext) {
      this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void open(ReadableMap options) {
        Activity activity = this.reactContext.getCurrentActivity();
  
        if (activity == null) {
          return;
        }
  
        Intent chooser;
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        
        sharingIntent.setType("text/plain");
        String shareBody = options.getString("message");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        chooser = Intent.createChooser(sharingIntent, "Share via");
        
        activity.startActivityForResult(chooser, RNShareModule.SHARE_REQUEST_CODE);
    }
}
