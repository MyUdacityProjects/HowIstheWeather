package com.example.android.howistheweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.howistheweather.models.Forecast;
import com.example.android.howistheweather.models.ForecastList;
import com.example.android.howistheweather.services.OpenWeatherService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ArrayAdapter<String> mWeatherAdapter;
    OpenWeatherService mOpenWeatherService;
    Retrofit retrofit;
    SharedPreferences sharedpreferences;

    public MainActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        fetchWeatherData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ArrayList<String> weatherData = new ArrayList<String>();
        mWeatherAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.forecast_day, weatherData);
        ListView listView = (ListView) rootView.findViewById(R.id.forecast_listview);
        listView.setAdapter(mWeatherAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("WEATHER_DATA", mWeatherAdapter.getItem(position));
                startActivity(intent);
            }
        });
        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.OPEN_WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mOpenWeatherService = retrofit.create(OpenWeatherService.class);
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return rootView;
    }

    private void fetchWeatherData() {

        String defaultUnit = getResources().getString(R.string.pref_unit_default);
        String pincode = Utils.getPincode(getActivity());
        String unit = Utils.getUnits(getActivity());
        Call<ForecastList> weatherDataCall = mOpenWeatherService.weatherForecast(pincode,unit);
        weatherDataCall.enqueue(new Callback<ForecastList>() {
            @Override
            public void onResponse(Call<ForecastList> call, Response<ForecastList> response) {
                ForecastList forecastList = response.body();
                if (forecastList.getList() != null && forecastList.getList().size() != 0) {
                    ArrayList<String> weatherData = new ArrayList<String>();
                    android.text.format.Time dayTime = new android.text.format.Time();
                    dayTime.setToNow();
                    int julianStartDay = Time.getJulianDay(System.currentTimeMillis(), dayTime.gmtoff);
                    dayTime = new Time();
                    int i = 0;
                    for (Forecast forecast : forecastList.getList()) {
                        long dateTime;
                        // Cheating to convert this to UTC time, which is what we want anyhow
                        dateTime = dayTime.setJulianDay(julianStartDay + i);
                        String day = new SimpleDateFormat("EEE MMM dd").format(dateTime);
                        int maxTemp = Math.round(forecast.getTemp().getMax());
                        int minTemp = Math.round(forecast.getTemp().getMin());
                        String weatherType = forecast.getWeather().get(0).getMain();
                        weatherData.add(day + " - " + weatherType + " - " + maxTemp + "/" + minTemp);
                        i++;
                    }
                    mWeatherAdapter.clear();
                    for (String weather : weatherData) {
                        mWeatherAdapter.add(weather);
                    }
                }


            }

            @Override
            public void onFailure(Call<ForecastList> call, Throwable t) {
                System.out.print("Oh! but hola");

            }
        });
    }
}
