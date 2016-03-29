package com.example.android.howistheweather.models;

public class Temperature {
    public Float day;
    public Float min;
    public Float max;
    public Float night;
    public Float eve;
    public Float morn;

    public Temperature(Float day, Float min, Float max, Float night, Float eve, Float morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    public Float getDay() {
        return day;
    }

    public void setDay(Float day) {
        this.day = day;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getNight() {
        return night;
    }

    public void setNight(Float night) {
        this.night = night;
    }

    public Float getEve() {
        return eve;
    }

    public void setEve(Float eve) {
        this.eve = eve;
    }

    public Float getMorn() {
        return morn;
    }

    public void setMorn(Float morn) {
        this.morn = morn;
    }
}
