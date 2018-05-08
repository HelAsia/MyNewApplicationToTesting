package com.introtoandroid.mynewapplicationtotesting;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;

public class FileStreamOfConsciousnessActivity extends AppCompatActivity {

  public static final String LOG_FILENAME = "Chat_Log.txt";
  private Handler mHandler = new Handler();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_file_stream_of_consciousness);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    final Button sendButton = (Button) findViewById(R.id.ButtonSend);
    sendButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        logChatMessage();
        final EditText chatText = (EditText) findViewById(R.id.EditTextChat);
        chatText.setText(null);
      }
    });

    final Button gotoLog = (Button) findViewById(R.id.ButtonSeeLog);
    gotoLog.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(FileStreamOfConsciousnessActivity.this, ViewLogActivity.class);
        startActivity(intent);
      }
    });
  }

  private void logChatMessage() {
    new Thread() {
      public void run() {
        final EditText chatText = (EditText) findViewById(R.id.EditTextChat);
        String strChat = chatText.getText().toString();

        if (strChat.length() > 0) {
          strChat = strChat + "\n\n";
          try{
            FileOutputStream fIO = openFileOutput(LOG_FILENAME, MODE_APPEND);
            fIO.write(strChat.getBytes());
            fIO.close();
            mHandler.post(new Runnable() {
              @Override
              public void run() {
                Toast.makeText(FileStreamOfConsciousnessActivity.this, "Text has been wrote in log. ", Toast.LENGTH_SHORT)
                    .show();
              }
            });
          }catch (Exception e) {

          }
        }
      }
    }.start();
  }
}
