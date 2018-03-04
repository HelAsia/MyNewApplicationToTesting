package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EquationActivity extends AppCompatActivity {
    Button button;
    Context context;
    TextView tvAddResult;
    TextView tvSubtractResult;
    TextView tvMultiplyResult;
    TextView tvDivideResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);

        button = (Button) findViewById(R.id.resultButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = getApplicationContext();
                Intent newScreen = new Intent (context, ResultsActivity.class);

                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();

                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();

                newScreen.putExtra("one",numberOneString);
                newScreen.putExtra("two",numberTwoString);

                startActivity(newScreen);
            }
        });

        button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();

                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();

                Counter counter = new Counter(numberOneString,numberTwoString);

                tvAddResult = (TextView) findViewById(R.id.addTextView);
                tvAddResult.setText(numberOneString + " + " + numberTwoString + " = " + counter.getAddResult());
            }
        });

        button = (Button) findViewById(R.id.subtractButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();

                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();

                Counter counter = new Counter(numberOneString,numberTwoString);

                tvSubtractResult = (TextView) findViewById(R.id.subtractTextView);
                tvSubtractResult.setText(numberOneString + " - " + numberTwoString + " = " + counter.getSubtractResult());
            }
        });

        button = (Button) findViewById(R.id.multiplyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();

                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();

                Counter counter = new Counter(numberOneString,numberTwoString);

                tvMultiplyResult = (TextView) findViewById(R.id.multiplyTextView);
                tvMultiplyResult.setText(numberOneString + " * " + numberTwoString + " = " + counter.getMultiplyResult());
            }
        });

        button = (Button) findViewById(R.id.divideButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();

                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();

                Counter counter = new Counter(numberOneString,numberTwoString);

                tvDivideResult = (TextView) findViewById(R.id.divideTextView);
                tvDivideResult.setText(numberOneString + " / " + numberTwoString + " = " + counter.getDivideResult());
            }
        });
    }
}
