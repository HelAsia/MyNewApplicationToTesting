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
public class SwipeFirstFragment extends Fragment {
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static SwipeFirstFragment newInstance(int page, String title){
        SwipeFirstFragment swipeFirstFragment = new SwipeFirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt",page);
        args.putString("someTitle",title);
        swipeFirstFragment.setArguments(args);
        return swipeFirstFragment;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt",0);
        title = getArguments().getString("someTitle");
    }

    public SwipeFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swipe_first, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(page + " -- " + title);
        return view;
    }

}