package com.introtoandroid.mynewapplicationtotesting;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class DefaultActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_styles_and_themes);

    Toolbar actionBar = ( Toolbar ) findViewById(R.id.toolbar_simple);
    setSupportActionBar(actionBar);

    ActionBar ab = getSupportActionBar();
    assert ab != null;
    ab.setDisplayHomeAsUpEnabled(true);

    EditText editText = ( EditText ) findViewById(R.id.editText02);
    editText.setSelection(editText.getText().length());

    FloatingActionButton fab = ( FloatingActionButton ) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Floating Action Bar", Toast.LENGTH_SHORT).show();
      }
    });

    Toolbar bottomBar = ( Toolbar ) findViewById(R.id.bottom_bar);
    assert bottomBar != null;

    ImageButton mapButton = ( ImageButton ) bottomBar.findViewById(R.id.map_button);
    if (mapButton != null) {
      mapButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Toast.makeText(getApplicationContext(), "Map Button", Toast.LENGTH_SHORT).show();
        }
      });
    }

    ImageButton emailButton = ( ImageButton ) bottomBar.findViewById(R.id.email_button);
    if (emailButton != null) {
      emailButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Toast.makeText(getApplicationContext(), "Email Button", Toast.LENGTH_SHORT).show();
        }
      });
    }

    ImageButton infoButton = ( ImageButton ) bottomBar.findViewById(R.id.info_button);
    if (infoButton != null) {
      infoButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Toast.makeText(getApplicationContext(), "Info Button", Toast.LENGTH_SHORT).show();
        }
      });
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_simple_styles, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_bright) {
      Intent intent = new Intent(this, BrightActivity.class);
      startActivity(intent);
      return true;
    }else if (id == R.id.action_dark) {
      Intent intent = new Intent(this, DarkActivity.class);
      startActivity(intent);
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
