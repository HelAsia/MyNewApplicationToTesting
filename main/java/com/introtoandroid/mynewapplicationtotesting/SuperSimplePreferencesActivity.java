package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public abstract class SuperSimplePreferencesActivity extends Activity {
  public static final String PREFERENCE_FILENAME = "AppPrefs";
  public static final String PREFERENCE_STRING_NAME = "StringPreActivity";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_preferences);

    SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
    SharedPreferences settingsActivity = getPreferences(MODE_PRIVATE);

    final TextView activityName = (TextView) findViewById(R.id.Title);
    String localClassName = this.getLocalClassName();
    activityName.setText(localClassName);

    final TextView prefs = (TextView) findViewById(R.id.CurrentPrefs);
    prefs.setText(settings.getAll().toString());

    final TextView prefsAct = (TextView) findViewById(R.id.CurrentActivityPrefs);
    prefsAct.setText(settingsActivity.getAll().toString());

    final Button goButton = (Button) findViewById(R.id.ButtonGo);
    if (localClassName.equals("SimplePreferencesActivity")) {
      goButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(SuperSimplePreferencesActivity.this, GetTargetClass());
          startActivity(intent);
        }
      });
    } else {
      goButton.setVisibility(View.INVISIBLE);
    }

    final Button prefAddActButton = (Button) findViewById(R.id.ButtonAddActivityPref);
    prefAddActButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final EditText prefName = (EditText) findViewById(R.id.EditTextPrefName);
        final EditText prefValue = (EditText) findViewById(R.id.EditTextPrefValue);
        final TextView prefs = (TextView) findViewById(R.id.CurrentActivityPrefs);

        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor prefEditor = settings.edit();

        String strPrefName = prefName.getText().toString();
        String strPrefValue = prefValue.getText().toString();

        prefEditor.putString(strPrefName, strPrefValue);
        prefEditor.apply();

        prefs.setText(settings.getAll().toString());
      }
    });

    final Button clearActPrefByNameButton = (Button) findViewById(R.id.ButtonClearActPrefByName);
    clearActPrefByNameButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {

        final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        final TextView prefs = (TextView)findViewById(R.id.CurrentActivityPrefs);

        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor prefEditor = settings.edit();

        String strPrefName = prefName.getText().toString();

        if(settings.contains(strPrefName)) {
          prefEditor.remove(strPrefName);
        }

        prefEditor.apply();
        prefs.setText(settings.getAll().toString());
      }
    });

    final Button clearButton = (Button) findViewById(R.id.ButtonClearAct);
    clearButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        final TextView prefs = (TextView)findViewById(R.id.CurrentActivityPrefs);

        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor prefEditor = settings.edit();

        prefEditor.clear();
        prefEditor.apply();

        prefs.setText(settings.getAll().toString());

        Toast.makeText(SuperSimplePreferencesActivity.this, "Activity preference has been deleted", Toast.LENGTH_SHORT).show();
      }
    });

    final Button prefButton = (Button) findViewById(R.id.ButtonAddSharedPref);
    prefButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {


        final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        final EditText prefValue = (EditText)findViewById(R.id.EditTextPrefValue);
        final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);

        SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
        SharedPreferences.Editor prefEditor = settings.edit();

        String strPrefName = prefName.getText().toString();
        String strPrefValue = prefValue.getText().toString();

        prefEditor.putString(strPrefName, strPrefValue);
        prefEditor.apply();

        prefs.setText(settings.getAll().toString());
      }
    });

    final Button clearPrefByNameButton = (Button) findViewById(R.id.ButtonClearSharedPrefByName);
    clearPrefByNameButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {

        final EditText prefName = (EditText)findViewById(R.id.EditTextPrefName);
        final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);

        SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
        SharedPreferences.Editor prefEditor = settings.edit();

        String strPrefName = prefName.getText().toString();

        if(settings.contains(strPrefName)) {
          prefEditor.remove(strPrefName);
        }

        prefEditor.apply();
        prefs.setText(settings.getAll().toString());
      }
    });

    final Button clearSharedButton = (Button) findViewById(R.id.ButtonClearShared);
    clearSharedButton.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        final TextView prefs = (TextView)findViewById(R.id.CurrentPrefs);

        SharedPreferences settings = getSharedPreferences(PREFERENCE_FILENAME, 0);
        SharedPreferences.Editor prefEditor = settings.edit();

        prefEditor.clear();
        prefEditor.apply();

        prefs.setText(settings.getAll().toString());

        Toast.makeText(SuperSimplePreferencesActivity.this, "Shared preferences have been deleted", Toast.LENGTH_SHORT).show();
      }
    });
    settings.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
      public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Toast.makeText(SuperSimplePreferencesActivity.this, "Preference's value has been changed: " + key, Toast.LENGTH_SHORT).show();
      }
    });
  }
  abstract Class<?> GetTargetClass();

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_super_simple_preferences, menu);
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
