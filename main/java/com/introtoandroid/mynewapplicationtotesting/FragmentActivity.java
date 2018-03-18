package com.introtoandroid.mynewapplicationtotesting;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentActivity extends Activity {

        Button firstFragment, secondFragment, thirdFragment;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fragment);
            firstFragment = (Button) findViewById(R.id.button1);
            secondFragment = (Button) findViewById(R.id.button2);
            thirdFragment = (Button) findViewById(R.id.button3);

            firstFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadFragment(new FragmentOne());
                }
            });

            secondFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadFragment(new FragmentTwo());
                }
            });

            thirdFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadFragment(new FragmentThree());
                }
            });
        }

        private void loadFragment(Fragment fragment) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fragment);
            fragmentTransaction.commit();

        }
    }
