package com.example.course4.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.course4.BR;
import com.example.course4.net.XMLCity;
import com.example.course4.net.XMLWeather;

public class Weather extends BaseObservable {

    @Bindable
    private String province;
    @Bindable
    private String city;
    @Bindable
    private String maxTemp;
    @Bindable
    private String minTemp;
    @Bindable
    private String weather;
    @Bindable
    private String wind;
    @Bindable
    private String time;

    public Weather(String province, String city, String maxTemp, String minTemp, String weather, String wind, String time) {
        this.province = province;
        this.city = city;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.weather = weather;
        this.wind = wind;
        this.time = time;
    }

    public Weather(XMLCity xml, String time){
        this.province = xml.getProvinceName();
        this.city = xml.getCityName();
        this.maxTemp = xml.getMaxTem();
        this.minTemp = xml.getMiniTem();
        this.weather = xml.getState();
        this.wind = xml.getWind();
        this.time = time;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
        notifyPropertyChanged(BR.province);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        notifyPropertyChanged(BR.city);
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
        notifyPropertyChanged(BR.maxTemp);
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
        notifyPropertyChanged(BR.minTemp);
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyPropertyChanged(BR.weather);
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
        notifyPropertyChanged(BR.wind);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }
}
