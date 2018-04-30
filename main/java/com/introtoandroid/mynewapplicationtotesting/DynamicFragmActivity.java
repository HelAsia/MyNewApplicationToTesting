package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class DynamicFragmActivity extends Activity implements
        OverviewFragment.OverviewFragmentActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragm);
    }

    @Override
    public void onItemSelected(String msg) {
        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);

        if(fragment != null && fragment.isInLayout()) {
            fragment.setText(msg);
        }else {
            Intent intent = new Intent(getApplicationContext(),
                    DetailActivity.class);
            intent.putExtra("msg",msg);
            startActivity(intent);
        }
    }
}
