package com.example.course4.net;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET("wmaps/xml/china.xml")
    Observable<XMLWeather> getWeather();
}
