package com.introtoandroid.mynewapplicationtotesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DateTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        TextView txtData = (TextView)findViewById(R.id.data);
        TextView txtCzas = (TextView)findViewById(R.id.czas);

        Intent i = getIntent();

        String data = i.getStringExtra("data");
        String czas = i.getStringExtra("czas");

        txtData.setText(data);
        txtCzas.setText(czas);

    }
}
