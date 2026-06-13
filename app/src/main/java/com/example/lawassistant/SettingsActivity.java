package com.example.lawassistant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState,
                                        String rootKey) {

            setPreferencesFromResource(
                    R.xml.preference,
                    rootKey
            );

            SwitchPreferenceCompat darkMode =
                    findPreference("dark_mode");

            if (darkMode != null) {

                darkMode.setOnPreferenceChangeListener(
                        (preference, newValue) -> {

                            boolean enabled =
                                    (Boolean) newValue;

                            if (enabled) {
                                AppCompatDelegate.setDefaultNightMode(
                                        AppCompatDelegate.MODE_NIGHT_YES
                                );
                            } else {
                                AppCompatDelegate.setDefaultNightMode(
                                        AppCompatDelegate.MODE_NIGHT_NO
                                );
                            }

                            requireActivity().recreate();

                            return true;
                        });
            }
        }
    }
}