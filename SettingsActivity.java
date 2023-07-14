package com.example.teamcounter;

import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.Preference;

public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private EditTextPreference favoriteTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        private SharedPreferences preferences;
        private EditTextPreference favoriteTeams;





        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);

            preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());


            favoriteTeams = findPreference("favorite_team");


            if(favoriteTeams != null){
                String favoriteTeam = preferences.getString("favorite_team", "");
                favoriteTeams.setSummary(favoriteTeam);
            }


        }

        private EditTextPreference findPreference(String key){
            Preference preference = getPreferenceManager().findPreference(key);
            if (preference instanceof EditTextPreference){
                return (EditTextPreference) preference;
            }
            return null;
        }



    }
}