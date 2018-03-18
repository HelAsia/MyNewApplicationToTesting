package com.introtoandroid.mynewapplicationtotesting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SwipeSecondFragment extends Fragment {
    private String title;
    private int page;

    public SwipeSecondFragment() {
        // Required empty public constructor
    }

    // newInstance constructor for creating fragment with arguments
    public static SwipeSecondFragment newInstance(int page, String title) {
        SwipeSecondFragment fragmentSecond = new SwipeSecondFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe_second, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);
        return view;
    }

}
