package com.example.flightscorevoardv2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment {

    private RadioGroup radioGroupAirport;
    private SharedPreferences sharedPreferences;

    private static final String PREFS_NAME = "FlightPreferences";
    private static final String AIRPORT_KEY = "selectedAirport";
    private static final String TAG = "SettingsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        radioGroupAirport = view.findViewById(R.id.radioGroupAirport);
        sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, 0);

        String selectedAirport = sharedPreferences.getString(AIRPORT_KEY, "Шереметьево");
        Log.d(TAG, "Loaded selected airport: " + selectedAirport);
        if (selectedAirport.equals("Шереметьево")) {
            radioGroupAirport.check(R.id.radioButtonSheremetyevo);
        } else if (selectedAirport.equals("Домодедово")) {
            radioGroupAirport.check(R.id.radioButtonDomodedovo);
        } else {
            radioGroupAirport.check(R.id.radioButtonVnukovo);
        }

        radioGroupAirport.setOnCheckedChangeListener((group, checkedId) -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            String airport = "Шереметьево"; // Default value
            if (checkedId == R.id.radioButtonSheremetyevo) {
                airport = "Шереметьево";
            } else if (checkedId == R.id.radioButtonDomodedovo) {
                airport = "Домодедово";
            } else if (checkedId == R.id.radioButtonVnukovo) {
                airport = "Внуково";
            }
            editor.putString(AIRPORT_KEY, airport);
            editor.apply();
            Log.d(TAG, "Saved selected airport: " + airport);

            // Обновляем заголовок активности, чтобы изменения применялись немедленно
            getActivity().setTitle(airport);
        });

        return view;
    }
}
