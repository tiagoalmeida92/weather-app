package com.talmeida.weather.app;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Tiago on 03/08/2016.
 */
public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
