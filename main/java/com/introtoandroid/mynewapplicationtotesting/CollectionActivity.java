package com.introtoandroid.mynewapplicationtotesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionActivity extends AppCompatActivity {
    int numberOfNoDuplicateNameI = 0;
    int numberOfNoDuplicateNameSum = 0;
    final List <String> namesList = new ArrayList<>();
   // List <String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        final TextView nameTv = (TextView) findViewById(R.id.nameTV);
        final Button buttonAdd = (Button) findViewById(R.id.name_add_button);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = nameTv.toString();
               namesList.add(name);
            }
        });

       final Button buttonDelete = (Button) findViewById(R.id.name_remove_button);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTv.toString();
                int itemDelete = namesList.indexOf(name);
                namesList.remove(itemDelete);
            }
        });

        final Button buttonCount = (Button) findViewById(R.id.button_count);
        final TextView listPrint = (TextView) findViewById(R.id.textViewList);

        buttonCount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                /*Set<String> set = new HashSet();
                for (int i = 0; i < namesList.size(); i++){
                    boolean nameSet = set.add(namesList.get(i));
                    if (nameSet == true){
                        numberOfNoDuplicateNameSum = numberOfNoDuplicateNameI;
                    }else {
                        numberOfNoDuplicateNameSum = numberOfNoDuplicateNameI + 1;
                    }
                    numberOfNoDuplicateNameI = numberDuplicateGetter(numberOfNoDuplicateNameI);
                }*/

                listPrint.setText("You number of no duplicate names is: " + numberOfNoDuplicateNameSum);

            }
        });



        Button firstFragment = (Button) findViewById(R.id.buttonShowList);
        firstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CollectionFragment());
            }
        });

    }
    List <String> list = namesListGetter(namesList);
    public int numberDuplicateGetter (int numberOfNoDuplicateNameI){
        return numberOfNoDuplicateNameI;
    }

    public List <String> namesListGetter (List <String> list){
        return list;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }
}
