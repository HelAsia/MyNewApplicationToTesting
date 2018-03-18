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

                String numberOne = getNumber(true);
                String numberTwo = getNumber(false);

                newScreen.putExtra("one",numberOne);
                newScreen.putExtra("two",numberTwo);

                startActivity(newScreen);
            }
        });

        button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumber(true);
                String numberTwo = getNumber(false);

                tvAddResult = (TextView) findViewById(R.id.addTextView);
                try{
                    Counter counter = new Counter(numberOne,numberTwo);
                    String ResultCounter = counter.getAddResult();

                    printResult(numberOne,numberTwo, tvAddResult, add, ResultCounter);
                }catch (NumberFormatException e){
                    tvAddResult.setText("You have to enter number and click again");
                }
            }
        });

        button = (Button) findViewById(R.id.subtractButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumber(true);
                String numberTwo = getNumber(false);

                tvSubtractResult = (TextView) findViewById(R.id.subtractTextView);
                try{
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getSubtractResult();

                printResult(numberOne,numberTwo, tvSubtractResult, subtract, ResultCounter);
                }catch (NumberFormatException e){
                    tvSubtractResult.setText("You have to enter number and click again");
                }
            }
        });

        button = (Button) findViewById(R.id.multiplyButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumber(true);
                String numberTwo = getNumber(false);

                tvMultiplyResult = (TextView) findViewById(R.id.multiplyTextView);
                try{
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getMultiplyResult();

                printResult(numberOne,numberTwo, tvMultiplyResult, multiply, ResultCounter);
                }catch (NumberFormatException e){
                    tvMultiplyResult.setText("You have to enter number and click again");
                }
            }
        });

        button = (Button) findViewById(R.id.divideButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOne = getNumber(true);
                String numberTwo = getNumber(false);

                tvDivideResult = (TextView) findViewById(R.id.divideTextView);
                try{
                Counter counter = new Counter(numberOne,numberTwo);
                String ResultCounter = counter.getDivideResult();

                printResult(numberOne,numberTwo, tvDivideResult, divide, ResultCounter);
                }catch (NumberFormatException e){
                    tvDivideResult.setText("You have to enter number and click again");
                }
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
        public void printResult(String numberOneString, String numberTwoString, TextView result, String operator, String getResult){

                result.setText(numberOneString + operator + numberTwoString + " = " + getResult);
        }

        public String getNumber (boolean choose){
            if (choose == true){
                TextView numberOneText = (TextView) findViewById(R.id.etNumberOne);
                String numberOneString = numberOneText.getText().toString();
                return numberOneString;
            }else {
                TextView numberTwoText = (TextView) findViewById(R.id.etNumberTwo);
                String numberTwoString = numberTwoText.getText().toString();
                return numberTwoString;
            }
        }

}
