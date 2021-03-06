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
    Context context;
    String element1 = "Animation";
    String element2 = "Equation";
    String element3 = "Fragments";
    String element4 = "FragmentSwipe";
    String element5 = "FragmentTooldbar";
    String element6 = "Buttons";
    String element7 = "Collections";
    String element8 = "DynamicFragments";
    String element9 = "PagerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView optionList = new ListView(this);
        setContentView(optionList);

        final String[] items = {element1, element2, element3, element4, element5, element6, element7, element8, element9};
        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(this, R.layout.activity_my_choose, R.id.option_name, items);

        optionList.setAdapter(optionAdapter);

        optionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                context = getApplicationContext();
                if (items[i] == element1) {
                    Intent intent = new Intent(context, AnimationActivity.class);
                    startActivity(intent);
                }else if (items[i] == element2) {
                    Intent intent = new Intent(context, EquationActivity.class);
                    startActivity(intent);
                }else if (items[i] == element3) {
                    Intent intent = new Intent(context, FragmentActivity.class);
                    startActivity(intent);
                }else if (items[i] == element4) {
                    Intent intent = new Intent(context, SwipeActivity.class);
                    startActivity(intent);
                }else if (items[i] == element5) {
                    Intent intent = new Intent(context, ExampleActivity.class);
                    startActivity(intent);
                }else if (items[i] == element6) {
                    Intent intent = new Intent(context, ButtonsActivity.class);
                    startActivity(intent);
                }else if (items[i] == element7) {
                    Intent intent = new Intent(context, CollectionActivity.class);
                    startActivity(intent);
                }else if (items[i] == element8) {
                    Intent intent = new Intent(context, DynamicFragmActivity.class);
                    startActivity(intent);
                }else if (items[i] == element9) {
                    Intent intent = new Intent(context, PagerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

