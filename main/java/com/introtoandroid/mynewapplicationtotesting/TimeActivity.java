package com.introtoandroid.mynewapplicationtotesting;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.DateFormat;

public class TimeActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        // Button4

        final Button btnNewScreen = (Button) findViewById(R.id.dane);
        btnNewScreen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                context = getApplicationContext();
                Intent newScreen = new Intent (context, DateTimeActivity.class);

                TimePicker myTimePicker = (TimePicker) findViewById(R.id.timePicker);
                String selectedTime = myTimePicker.getCurrentHour()+ " : " + myTimePicker.getCurrentMinute();
                newScreen.putExtra("czas",selectedTime);

                startActivity(newScreen);
            }
        });
    }
}
