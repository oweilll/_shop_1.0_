package com.example.flightscorevoardv2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "FlightPreferences";
    private static final String THEME_KEY = "selectedTheme";
    private static final String AIRPORT_KEY = "selectedAirport";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Установка темы перед вызовом setContentView
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDarkMode = sharedPreferences.getBoolean(THEME_KEY, false);
        if (isDarkMode) {
            setTheme(R.style.Theme_AppCompat);
        } else {
            setTheme(R.style.Theme_AppCompat_Light);
        }

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
        }

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                if (menuItem.getItemId() == R.id.nav_home)
                    selectedFragment = new HomeFragment();
                else if (menuItem.getItemId() == R.id.nav_profile)
                    selectedFragment = new ProfileFragment();
                else if (menuItem.getItemId() == R.id.nav_settings)
                    selectedFragment = new SettingsFragment();

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                }
                return true;
            }
        });

        // Обновление заголовка после установки темы и настройки вида
        updateTitle();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTitle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTitle();
    }

    private void updateTitle() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String selectedAirport = sharedPreferences.getString(AIRPORT_KEY, "Шереметьево");
        Log.d(TAG, "Update title with selected airport: " + selectedAirport);
        setTitle(selectedAirport);
    }
}
