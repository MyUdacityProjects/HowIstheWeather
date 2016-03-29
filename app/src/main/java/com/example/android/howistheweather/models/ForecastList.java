package com.example.android.howistheweather.models;

import java.util.List;

public class ForecastList {
    public Object city;
    public String cod;
    public Float message;
    public int cnt;

    public ForecastList(Object city, String cod, Float message, int cnt, List<Forecast> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Float getMessage() {
        return message;
    }

    public void setMessage(Float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }

    public List<Forecast> list;
}
