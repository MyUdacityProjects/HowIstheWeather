package com.example.android.howistheweather.services;

import com.example.android.howistheweather.models.ForecastList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherService {
    @GET("data/2.5/forecast/daily?mode=json&cnt=7")
    Call<ForecastList> weatherForecast(@Query("q") String pinCode, @Query("units") String unit);
}
