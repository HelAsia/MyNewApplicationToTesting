package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String url = extras.getString("msg");
            DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);

            detailFragment.setText(url);
        }
    }
}
