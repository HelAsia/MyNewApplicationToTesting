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


/**
 * A simple {@link Fragment} subclass.
 */

public class CollectionFragment extends Fragment  {
    Context context;
    CollectionActivity collectionActivity = new CollectionActivity();

    public CollectionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment


        ListView optionList2 = new ListView(context);
        if (collectionActivity.list != null){
            ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(context, R.layout.activity_collection, R.id.textViewTest, collectionActivity.list);
            optionList2.setAdapter(optionAdapter);

        }else {
            Toast.makeText(context,"List is empty",Toast.LENGTH_SHORT).show();
        }

        return inflater.inflate(R.layout.fragment_collection, container, false);
    }
}
