package com.introtoandroid.mynewapplicationtotesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        final List <String> namesList = new ArrayList<>();

        final TextView nameTv = (TextView) findViewById(R.id.nameTV);
        final TextView namesTvList = (TextView) findViewById(R.id.nameTV);

        final Button buttonAdd= (Button) findViewById(R.id.name_add_button);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTv.toString();

                namesList.add(name);
            }
        });

        /*final Button buttonDelete = (Button) findViewById(R.id.deleteButton);

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameTv.toString();
                int itemDelete = namesList.indexOf(name);
                namesList.remove(itemDelete);
            }
        });*/

        final Button buttonList = (Button) findViewById(R.id.button_show_list);
        final TextView listPrint = (TextView) findViewById(R.id.list_tv);

        int numberOfnoDuplicateNameI = 0;
        int numberOfnoDuplicateNameSum = 0;

        Set<String> set = new HashSet();
        for (int i = 0; i < namesList.size(); i++){
            boolean nameSet = set.add(namesList.get(i));
            if (nameSet == false){
                numberOfnoDuplicateNameSum = numberOfnoDuplicateNameI;
            }else {
                numberOfnoDuplicateNameSum = numberOfnoDuplicateNameI + 1;
            }
        }
        final String numberOfnoDuplicateNameS = Integer.toString(numberOfnoDuplicateNameSum);

        buttonList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                listPrint.setText("You number of no duplicate names is: " + numberOfnoDuplicateNameS);

            }
        });

    }
}
