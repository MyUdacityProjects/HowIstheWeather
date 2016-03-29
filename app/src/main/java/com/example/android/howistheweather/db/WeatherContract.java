package com.example.android.howistheweather.db;

import android.provider.BaseColumns;

public class WeatherContract {
    public static final class WeatherEntry implements BaseColumns {
        public static final String TABLE_NAME = "weather";

        // Column to store the maximum value of the temperature
        public static final String COLUMN_TEMP_MAX = "max";

        // Column to store the minimum value of the temperature
        public static final String COLUMN_TEMP_MIN = "min";

        // Column to store the value of the pressure
        public static final String COLUMN_PRESSURE = "pressure";

        // Column to store the type of weather e.g. clear
        public static final String COLUMN_WEATHER_CONDITION_ID = "weather_id";

        // Column to store a short description of the weather
        public static final String COLUMN_SHORT_DESC = "short_desc";

        // Column to store the value of the humidity
        public static final String COLUMN_HUMIDITY = "humidity";

        // Column to store the date value in milliseconds since epoch timestamp
        public static final String COLUMN_DATE = "date";

        // Windspeed is stored as a float representing windspeed  mph
        public static final String COLUMN_WIND_SPEED = "wind";

        // Degrees are meteorological degrees (e.g, 0 is north, 180 is south).  Stored as floats.
        public static final String COLUMN_DEGREES = "degrees";

        // Column to store the id of the location of the weather
        public static final String COLUMN_LOC_ID = "loc_id";

    }

    public static final class LocationEntry implements BaseColumns {
        public static final String TABLE_NAME = "location";

        // Column to setting of the location
        public static final String COLUMN_LOCATION_SETTING = "setting";

        // Column to store the name of the city
        public static final String COLUMN_CITY = "city";

        // Column to store the latitude of the location
        public static final String COLUMN_LAT = "lat";

        // Column to store the longitude of the location
        public static final String COLUMN_LONG = "long";

    }
}
