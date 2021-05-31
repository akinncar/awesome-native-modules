package com.awesomenativemodules.RNMap;

import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class RNMapManager extends ViewGroupManager<RNMapView> {
    private static final String REACT_CLASS = "RNMap";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RNMapView createViewInstance(ThemedReactContext reactContext) {
        return new RNMapView(reactContext);
    }
}
