package com.introtoandroid.mynewapplicationtotesting;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class MenuActivity extends AppCompatActivity
      implements ActivityCompat.OnRequestPermissionsResultCallback {
  private static final String DEBUG_TAG = "MenuActivity";
  private SortedMap<String, Object> actions = new TreeMap<>();

  private static final int REQUEST_EXTERNAL_STORAGE = 0;
  private static String[] PERMISSIONS_EXTERNAL_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE};

  private static final int REQUEST_CALL_LOG = 1;
  private static String[] PERMISSIONS_CALL_LOG = {Manifest.permission.READ_CALL_LOG};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_layout);

    ListView av = (ListView) findViewById(R.id.list);

    prepareMenu();
    String[] keys = actions.keySet().toArray(
        new String[actions.keySet().size()]);
    av.setAdapter(new ArrayAdapter<>(this,
        android.R.layout.simple_list_item_1, keys));

    av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(SimpleContentProviderActivity.DEBUG_TAG, "poz: " + position + " , id: " + id);
        handleClick((ListView) parent, view, position, id);
      }
    });
  }

  public void addMenuItem(String label, Class<?> cls) {
    actions.put(label, new Intent(this, cls));
  }
  abstract void prepareMenu();

  protected void handleClick(ListView l, View v, int position, long id) {
    if (position == 0) {
      if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
          != PackageManager.PERMISSION_GRANTED) {
        Log.i(DEBUG_TAG, "Brak uprawnień na dostęp do pamięci zewnętrznej. Proszę o przydzielenie uprawnienia.");
        ActivityCompat.requestPermissions(MenuActivity.this, PERMISSIONS_EXTERNAL_STORAGE,
                REQUEST_EXTERNAL_STORAGE);
      } else {
        String key = (String) l.getItemAtPosition(position);
        startActivity((Intent) actions.get(key));
      }
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == REQUEST_EXTERNAL_STORAGE) {
      if (verifyPermissions(grantResults)) {
        Toast.makeText(this, "Przydzielono uprawnienia na dostęp do pamięci zewnętrznej",
            Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(this, "Odmówiono przydzielenia uprawnień na dostęp do rejestru połączeń.",
            Toast.LENGTH_SHORT).show();
      }
    }else {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
  }

  public static boolean verifyPermissions(int[] grantResults) {
    // Jedne wynik musi być dostępny.
    if (grantResults.length < 1) {
      return false;
    }

    // Sprawdzamy czy przydzielono każde z wymaganych uprawnień.
    for (int result : grantResults) {
      if (result != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }
}
