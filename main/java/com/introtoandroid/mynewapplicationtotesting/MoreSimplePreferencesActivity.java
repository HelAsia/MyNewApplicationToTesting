package com.introtoandroid.mynewapplicationtotesting;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MoreSimplePreferencesActivity extends SuperSimplePreferencesActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    SharedPreferences settingsActivity = getPreferences(MODE_PRIVATE);
    if(!settingsActivity.contains(PREFERENCE_STRING_NAME)) {
      SharedPreferences.Editor prefEditor = settingsActivity.edit();
      prefEditor.putString(PREFERENCE_STRING_NAME, this.getLocalClassName());
      prefEditor.putLong("SomeLong", java.lang.Long.MIN_VALUE);
      prefEditor.apply();
    }
    super.onCreate(savedInstanceState);
  }

  @Override
  Class<?> GetTargetClass() {
    return SimplePreferencesActivity.class;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_more_simple_preferences, menu);
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
