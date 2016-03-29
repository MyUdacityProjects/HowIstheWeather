package com.example.android.howistheweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    private ShareActionProvider mShareActionProvider;
    private String mForecast;
    private static final String FORECAST_SHARE_HASHTAG = " #How Is the Weather";

    public DetailActivityFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu_main, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        // If onLoadFinished happens before this, we can go ahead and set the share intent now.
        if (mForecast != null && mShareActionProvider!= null) {
            mShareActionProvider.setShareIntent(createShareForecastIntent());
        }
    }

    private Intent createShareForecastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForecast + FORECAST_SHARE_HASHTAG);
        return shareIntent;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_refresh) {
            Toast.makeText(getActivity(), getString(R.string.action_refresh), Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.action_map) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Utils.getGeoLocation(getContext()));
            if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                startActivity(intent);
            }
            return true;
        }

        if (id == R.id.action_settings) {
            Intent intent = new Intent(getContext(), SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        if (savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if (extras == null) {
                mForecast = null;
            } else {
                mForecast = extras.getString("WEATHER_DATA");
            }
        } else {
            mForecast = (String) savedInstanceState.getSerializable("WEATHER_DATA");
        }
        TextView forecastTextView = (TextView) rootView.findViewById(R.id.forecast_data_textview);
        forecastTextView.setText(mForecast);
        return rootView;
    }


}
