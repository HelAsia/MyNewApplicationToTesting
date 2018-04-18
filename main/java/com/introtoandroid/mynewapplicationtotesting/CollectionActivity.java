package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CollectionActivity extends AppCompatActivity {

    Context context;
    int numberOfNoDuplicateNameI = 0;
    int numberOfNoDuplicateNameSum = 0;
    final ArrayList <String> namesList = new ArrayList<>();
   // List <String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        context = getApplicationContext();

        final TextView nameTv = (TextView) findViewById(R.id.nameTV);
        final Button buttonAdd = (Button) findViewById(R.id.name_add_button);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = nameTv.getText().toString();
                namesList.add(name);
                if (name == null){
                    Toast.makeText(context,"Name is empty",Toast.LENGTH_SHORT).show();
                }else{
                    if (namesList.size() > 1){
                        String namesSizeString = String.valueOf(namesList.size());
                        Toast.makeText(context,namesSizeString,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context,"0",Toast.LENGTH_SHORT).show();
                    }
                  }
            }
        });

       final Button buttonDelete = (Button) findViewById(R.id.name_remove_button);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTv.getText().toString();
                int itemDelete = namesList.indexOf(name);
                namesList.remove(itemDelete);
            }
        });

        final Button buttonCount = (Button) findViewById(R.id.button_count);
        final TextView countPrint = (TextView) findViewById(R.id.textViewList);

        buttonCount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Set<String> set = new HashSet();
                for (int i = 0; i < namesList.size(); i++){
                    boolean nameSet = set.add(namesList.get(i));
                    if (nameSet == true){
                        numberOfNoDuplicateNameI = numberDuplicateGetter(numberOfNoDuplicateNameSum +1);
                    }else {
                        numberOfNoDuplicateNameI = numberDuplicateGetter(numberOfNoDuplicateNameSum);
                    }
                    numberOfNoDuplicateNameSum = numberDuplicateGetter(numberOfNoDuplicateNameI);
                }

                countPrint.setText("You number of no duplicate names is: " + numberOfNoDuplicateNameSum);

            }
        });

        Button firstFragment = (Button) findViewById(R.id.buttonShowList);

        firstFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list",namesList);

                loadFragment(new CollectionFragment(), bundle);
            }
        });
    }

    public int numberDuplicateGetter (int numberOfNoDuplicateNameI){
        return numberOfNoDuplicateNameI;
    }

    private void loadFragment(Fragment fragment, Bundle args) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragment.setArguments(args);
        fragmentTransaction.replace(R.id.fragment_layout, fragment);
        fragmentTransaction.commit();
    }
}
