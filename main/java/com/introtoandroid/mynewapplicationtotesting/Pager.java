package com.introtoandroid.mynewapplicationtotesting;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Asia on 2018-04-30.
 */

public class Pager extends FragmentStatePagerAdapter {
    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabOneFragment tab1 = new TabOneFragment();
                return tab1;
            case 1:
                TabTwoFragment tab2 = new TabTwoFragment();
                return tab2;
            case 2:
                TabThreeFragment tab3 = new TabThreeFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}