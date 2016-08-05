package com.talmeida.weather.services;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import com.talmeida.weather.services.entity.ForecastResponse;

/**
 * Created by Tiago on 03/08/2016.
 */
public interface WeatherApi {

    @GET("/api/426e3192c126f92d/forecast/q/{country}/{city}.json")
    Call<ForecastResponse> getForecast(@Path("country") String country, @Path("city") String city);
}
