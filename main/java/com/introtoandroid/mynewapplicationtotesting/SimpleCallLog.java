package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.util.Log;

/**
 * Created by Asia on 2018-05-12.
 */

public class SimpleCallLog extends Activity {
  private static final String DEBUG_TAG = "SimpleCallLog";

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_content_provider);
    try{
      String[] requestedColumns = {
          Calls.CACHED_NUMBER_LABEL,
          Calls.DURATION
      };
      CursorLoader loader = new CursorLoader(this,
          Calls.CONTENT_URI,
          requestedColumns,
          Calls.CACHED_NUMBER_LABEL + " = ?",
          new String[] {"HourlyClient123"},
          null);
      Cursor calls = loader.loadInBackground();

      int durIdx = calls.getColumnIndex(Calls.DURATION);
      int totalDuration = 0;
      calls.moveToFirst();
      while (!calls.isAfterLast()) {
        totalDuration += calls.getInt(durIdx);
        calls.moveToNext();
      }
      Log.d(DEBUG_TAG, "'HourlyClient123' - talking time: " + totalDuration);
    }catch (Exception e) {
      Log.e(DEBUG_TAG, "Exception: ", e);
    }
  }
}
