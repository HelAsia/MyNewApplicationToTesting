package com.introtoandroid.mynewapplicationtotesting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Method;

public class EquationActivity extends AppCompatActivity {
    Button button;
    Context context;
    TextView tvAddResult;
    TextView tvSubtractResult;
    TextView tvMultiplyResult;
    TextView tvDivideResult;
    String add = " + ";
    String subtract = " - ";
    String multiply = " * ";
    String divide = " / ";

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
                String numberOne = getNumberOne();
                String numberTwo = getNumberTwo();

                tvAddResult = (TextView) findViewById(R.id.addTextView);
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getAddResult();

                checkEmptyString(numberOne,numberTwo, tvAddResult, add, ResultCounter);
            }
        });

        button = (Button) findViewById(R.id.subtractButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumberOne();
                String numberTwo = getNumberTwo();

                tvSubtractResult = (TextView) findViewById(R.id.subtractTextView);
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getSubtractResult();

                checkEmptyString(numberOne,numberTwo, tvSubtractResult, subtract, ResultCounter);
            }
        });

        button = (Button) findViewById(R.id.multiplyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumberOne();
                String numberTwo = getNumberTwo();

                tvMultiplyResult = (TextView) findViewById(R.id.multiplyTextView);
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getMultiplyResult();

                checkEmptyString(numberOne,numberTwo, tvMultiplyResult, multiply, ResultCounter);
            }
        });

        button = (Button) findViewById(R.id.divideButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumberOne();
                String numberTwo = getNumberTwo();

                tvDivideResult = (TextView) findViewById(R.id.divideTextView);
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getDivideResult();

                checkEmptyString(numberOne,numberTwo, tvDivideResult, divide, ResultCounter);
            }
        });

        button = (Button) findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvAddResult = (TextView) findViewById(R.id.addTextView);
                tvSubtractResult = (TextView) findViewById(R.id.subtractTextView);
                tvMultiplyResult = (TextView) findViewById(R.id.multiplyTextView);
                tvDivideResult = (TextView) findViewById(R.id.divideTextView);
                tvAddResult.setText(" ");
                tvSubtractResult.setText(" ");
                tvMultiplyResult.setText(" ");
                tvDivideResult.setText(" ");
            }
        });
    }
        public void checkEmptyString (String numberOneString, String numberTwoString, TextView result, String operator, String getResult){
            if (numberOneString.equals("") || numberTwoString.equals("")) {
                result.setText("You have to enter number and click again");
            }else {
                result.setText(numberOneString + operator + numberTwoString + " = " + getResult);
            }
        }

        public String getNumberOne (){
            TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
            String numberOneString = numberOneText.getText().toString();
            return numberOneString;
        }

        public String getNumberTwo (){
            TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
            String numberTwoString = numberTwoText.getText().toString();
            return numberTwoString;
        }

}
