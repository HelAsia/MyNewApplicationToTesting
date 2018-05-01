package com.introtoandroid.mynewapplicationtotesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuExampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_menu_example);

      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu_example_activity, menu);
      return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
        case R.id.menu_add:
          Toast.makeText(this, "Kliknięto 'Dodaj'", Toast.LENGTH_SHORT).show();
          return true;
        case R.id.menu_close:
          finish();
          return true;
        case R.id.menu_help:
          Toast.makeText(this, "Kliknięto 'Pomoc'", Toast.LENGTH_SHORT).show();
          return true;
        default:
          return super.onOptionsItemSelected(item);
      }
    }
}
