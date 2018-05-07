package com.introtoandroid.mynewapplicationtotesting;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;

public class UserPrefsHeadersActivity extends PreferenceActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
  @Override
  public void onBuildHeaders(List<Header> target) {
    loadHeadersFromResource(R.xml.preference_headers, target);
  }

  protected boolean isValidFragment(String fragmentName) {
    return UserNameFragment.class.getName().equals(fragmentName)
        || GameSettingsFragment.class.getName().equals(fragmentName)
        || CharacterSettingsFragment.class.getName().equals(fragmentName);
  }

  public static class UserNameFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      PreferenceManager manager = getPreferenceManager();
      manager.setSharedPreferencesName("user_prefs");
      addPreferencesFromResource(R.xml.personal_settings);
    }
  }

  public static class GameSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      PreferenceManager manager = getPreferenceManager();
      manager.setSharedPreferencesName("user_prefs");
      addPreferencesFromResource(R.xml.game_settings);
    }
  }

  public static class CharacterSettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      PreferenceManager manager = getPreferenceManager();
      manager.setSharedPreferencesName("user_prefs");
      addPreferencesFromResource(R.xml.character_settings);
    }
  }
}
