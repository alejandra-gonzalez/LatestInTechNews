package com.example.android.latestintechnews;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;

/**
 * Reference for PreferenceFragmentCompat:
 * August 4, 2018
 * https://medium.com/@JakobUlbrich/building-a-settings-screen-for-android-part-1-5959aa49337c
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public static class ArticlePreferenceFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener{

        /**
         * Loads preferences from res/xml/settings_main.
         */
        @Override
        public void onCreatePreferences(Bundle bundle, String s) {
            addPreferencesFromResource(R.xml.settings_main);

            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            bindPreferenceSummaryToValue(orderBy);

            Preference filterByCompany = findPreference(getString(R.string.settings_filter_by_company_key));
            bindPreferenceSummaryToValue(filterByCompany);

            Preference filterBySection = findPreference(getString(R.string.settings_filter_by_section_key));
            bindPreferenceSummaryToValue(filterBySection);
        }

        /**
         * From Lesson 7, Part 8
         * Updates the displayed preference summary when the preference is changed.
         */
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            // The code in this method takes care of updating the displayed preference summary after it has been changed
            String stringValue = value.toString();
            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        }

        /**
         * From Lesson 7, Part 8
         * Listens for changes to a preference.
         */
        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }
    }
}
