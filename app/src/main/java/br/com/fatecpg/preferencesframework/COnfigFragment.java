package br.com.fatecpg.preferencesframework;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;

public class COnfigFragment extends PreferenceFragment  implements SharedPreferences.OnSharedPreferenceChangeListener{

    private SwitchPreference prefMapsEnabled;
    private ListPreference prefUnit;
    private CheckBoxPreference prefSatelite;

    private Resources res;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.config);

        res = getActivity().getResources();

        prefMapsEnabled = (SwitchPreference) findPreference(res.getString(R.string.pref_map_enabled));
        prefUnit = (ListPreference) findPreference(res.getString(R.string.pref_un_dist));
        prefSatelite = (CheckBoxPreference) findPreference(res.getString(R.string.pref_satelite));

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        prefs.registerOnSharedPreferenceChangeListener(this);

        boolean defValue = res.getBoolean(R.bool.map_enabled_default);
        boolean enabled = prefs.getBoolean(res.getString(R.string.pref_map_enabled), defValue);

        setEnabled(enabled);
    }

    private void setEnabled(boolean enabled){
        prefUnit.setEnabled(enabled);
        prefSatelite.setEnabled(enabled);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(prefMapsEnabled.getKey())){
            boolean defValue = res.getBoolean(R.bool.map_enabled_default);
            boolean enabled = sharedPreferences.getBoolean(key, defValue);
            setEnabled(enabled);
        }
    }
}
