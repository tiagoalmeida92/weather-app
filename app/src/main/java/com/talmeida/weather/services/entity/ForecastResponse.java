package com.talmeida.weather.services.entity;

/**
 * Created by Tiago on 03/08/2016.
 */
public class ForecastResponse {

    public Response response;
    public Forecast forecast;

    public static class Response {
        public String version;
        public String termsofService;
        public Features features;

        public static class Features {
            public int forecast;
        }
    }

    public static class Forecast {
    }

    @Override
    public String toString() {
        return "ForecastResponse{" +
                "response=" + response +
                ", forecast=" + forecast +
                '}';
    }
}
