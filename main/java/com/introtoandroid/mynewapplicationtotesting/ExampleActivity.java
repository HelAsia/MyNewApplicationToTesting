package com.introtoandroid.mynewapplicationtotesting;

import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExampleActivity extends android.support.v4.app.FragmentActivity implements ToolbarFragment.ToolbarListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
    }

    public void onButtonClick(int fontsize, String text) {
        TextFragment textFragment =
                (TextFragment)
                        getSupportFragmentManager().findFragmentById(R.id.text_fragment);

        textFragment.changeTextProperties(fontsize, text);
    }
}
