package com.talmeida.weather.presenters;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.talmeida.weather.services.WeatherApi;
import com.talmeida.weather.services.entity.ForecastResponse;
import com.talmeida.weather.ui.MainView;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tiago on 03/08/2016.
 */
public class WeatherPresenter {

    private final WeatherApi weatherApi;
    private MainView mView;

    public WeatherPresenter(MainView view) {
        mView = view;
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.wunderground.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherApi = retrofit.create(WeatherApi.class);
    }

    public void loadForecast(){
        weatherApi.getForecast("PT", "Lisbon").enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                mView.onForecastLoaded(response.body());
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {

            }
        });
    }
}
