package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class CollectionFragment extends Fragment  {
    Context context;

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        ArrayList <String> myList = this.getArguments().getStringArrayList("list");
        // Inflate the layout for this fragment

        ListView optionList = new ListView(context);
        if (myList != null){
            Toast.makeText(context,"List is not empty",Toast.LENGTH_SHORT).show();
            ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(context, R.layout.fragment_collection, R.id.textViewTest, myList);
            optionList.setAdapter(optionAdapter);

        }else {
            Toast.makeText(context,"List is empty",Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_collection, container, false);
    }
}
