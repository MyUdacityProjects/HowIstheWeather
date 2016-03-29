package com.example.android.howistheweather.models;

import java.util.List;

public class Forecast {
    public Long dt;
    public Temperature temp;
    public Float pressure;
    public int humidity;
    public List<Weather> weather;
    public Float speed;
    public int deg;

    public Forecast(Long dt, Temperature temp, Float pressure, int humidity, List<Weather> weather, Float speed, int deg, int clouds) {
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public int clouds;
}
