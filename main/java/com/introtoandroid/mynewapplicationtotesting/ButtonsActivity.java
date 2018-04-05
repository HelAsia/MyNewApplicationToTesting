package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonsActivity extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
    }
    //Edit test with filter

    final EditText text_filtred = (EditText) findViewById(R.id.editText);
    text_filtred.setFilters(new InputFilter[]{
        new InputFilter.AllCaps(),
    });

    // Text with autocomplete

    final String[] COLORS = {
            "czerwony", "zielony", "pomarańczowy", "purpurowy",
            "czarny", "żółty", "szary", "fioletowy"
    };
    ArrayAdapter<String> adapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COLORS);
    AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
    text.setAdapter(adapter);

    // Spinner

    final Spinner spin = (Spinner) findViewById(R.id.spinner);
    TextView textSel = (TextView) spin.getSelectedView();

    // Button

    final Button basicButton = (Button) findViewById(R.id.button);
    basicButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            context = getApplicationContext();
            Intent intent = new Intent (context, DateActivity.class);
            startActivity(intent);
            Toast.makeText(ButtonsActivity.this,"Kliknięto przycisk",Toast.LENGTH_SHORT).show();
        }
    });



    // ImageButton

    final ImageButton basicImageButton = (ImageButton) findViewById(R.id.imageButton);
    basicImageButton.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        Toast.makeText(ButtonsActivity.this, "Kliknięto przycisk ze zdjęciem", Toast.LENGTH_SHORT).show();
    }
    }

    );

    // checkBox

    final CheckBox checkButton = (CheckBox) findViewById(R.id.checkBox);
    checkButton.setOnClickListener(new View.OnClickListener(){
        public void onClick (View v){
            CheckBox cb = (CheckBox) findViewById(R.id.checkBox);
            cb.setText(checkButton.isChecked() ?
                    "Pole zostało zaznaczone":
                    "Usunięto zaznaczenie pola");
        }
    });

    //RadioGroup

    final RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup01);
    final TextView tv = (TextView)findViewById(R.id.textView2);

    group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
        public void onCheckedChanged(RadioGroup group, int checkedId){
            if(checkedId !=-1) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                if (rb != null) {
                    tv.setText("Wybrałeś: " + rb.getText());
                }
            }
            else{
                tv.setText("Wybierz jedną z opcji");
            }
        }
    });
    final Button clearChoice = (Button) findViewById(R.id.button2);
    clearChoice.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
            RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup01);
            if(group != null){
                group.clearCheck();
            }
        }
    });
}
}
