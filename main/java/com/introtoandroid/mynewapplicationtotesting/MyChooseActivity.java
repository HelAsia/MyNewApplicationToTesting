package com.introtoandroid.mynewapplicationtotesting;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyChooseActivity extends AppCompatActivity {
    Context contex;
    String element1 = "Animation";
    String element2 = "Element 2";
    String element3 = "Element 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView optionList = new ListView(this);
        setContentView(optionList);

        final String[] items = {element1, element2, element3};
        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(this, R.layout.activity_my_choose, R.id.option_name, items);

        optionList.setAdapter(optionAdapter);

        optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            contex = getApplicationContext();
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (items[i] == element1) {
                    Intent intent = new Intent(contex, AnimationActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

