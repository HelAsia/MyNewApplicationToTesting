package com.introtoandroid.mynewapplicationtotesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ViewLogActivity extends AppCompatActivity {
  public static final String LOG_FILENAME = "Chat_Log.txt";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_log);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    assert getSupportActionBar() != null;
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    final TextView log = (TextView) findViewById(R.id.TextViewCurrentLogFile);

    try{
      InputStream iFile = openFileInput(LOG_FILENAME);
      log.setText(inputStreamToString(iFile));
    }catch (Exception e){
      log.setText("Couldn't read log file.");
    }

    final Button clearLog = (Button) findViewById(R.id.ButtonClearLog);
    clearLog.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (java.util.Arrays.binarySearch(fileList(), LOG_FILENAME) != (-1)) {
          deleteFile(LOG_FILENAME);
        }

        final TextView log = (TextView) findViewById(R.id.TextViewCurrentLogFile);
        log.setText(null);
      }
    });
  }

  public String inputStreamToString(InputStream is) throws IOException {
    StringBuffer sBuffer = new StringBuffer();
    BufferedReader dataIO = new BufferedReader(new InputStreamReader(is));
    String strLine;

    while ((strLine = dataIO.readLine()) != null) {
      sBuffer.append(strLine);
      sBuffer.append("\n");
    }

    dataIO.close();
    is.close();

    return sBuffer.toString();
  }
}
