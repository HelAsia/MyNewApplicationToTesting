package com.introtoandroid.mynewapplicationtotesting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SimplePreferencesActivity extends SuperSimplePreferencesActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    SharedPreferences settingsActivity = getPreferences(MODE_PRIVATE);
    if(!settingsActivity.contains(PREFERENCE_STRING_NAME)) {
      SharedPreferences.Editor prefEditor = settingsActivity.edit();
      prefEditor.putBoolean("Boolean_Pref", false);
      prefEditor.putFloat("Float_Pref", java.lang.Float.NEGATIVE_INFINITY);
      prefEditor.putInt("Int_Pref", java.lang.Integer.MIN_VALUE);
      prefEditor.putString(PREFERENCE_STRING_NAME, this.getLocalClassName());
      prefEditor.apply();
    }
    super.onCreate(savedInstanceState);

  }

  @Override
  Class<?> GetTargetClass() {
    return MoreSimplePreferencesActivity.class;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_simple_preferences, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
