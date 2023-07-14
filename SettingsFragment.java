package com.example.teamcounter;

import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.preference.PreferenceFragmentCompat;




public class SettingsFragment extends PreferenceFragmentCompat {
    private SharedPreferences preference;



    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }


}