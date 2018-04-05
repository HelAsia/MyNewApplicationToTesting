package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.DateFormat;

public class DateActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        // Zapisz datę przycisk

        final Button btnNewScreen = (Button) findViewById(R.id.zapisz_date);
        btnNewScreen.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                context = getApplicationContext();
                Intent newScreen = new Intent (context, DateTimeActivity.class);

                DatePicker myDatePicker = (DatePicker) findViewById(R.id.datePicker);
                String selectedDate = DateFormat.getDateInstance().format(myDatePicker.getCalendarView().getDate());
                newScreen.putExtra("data",selectedDate);

                startActivity(newScreen);
            }
        });

        // Ustaw godzinę przycisk

        final Button btnNewScreen2 = (Button) findViewById(R.id.ustaw_godzine);
        btnNewScreen2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                context = getApplicationContext();
                Intent newScreen2 = new Intent (context, TimeActivity.class);
                startActivity(newScreen2);
            }
        });
    }
}
