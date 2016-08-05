package com.talmeida.weather.ui;

import com.talmeida.weather.services.entity.ForecastResponse;

/**
 * Created by Tiago on 03/08/2016.
 */
public interface MainView {

    void onForecastLoaded(ForecastResponse response);
}
