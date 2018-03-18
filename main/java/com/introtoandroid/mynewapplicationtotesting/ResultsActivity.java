package com.introtoandroid.mynewapplicationtotesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    TextView tvAddResult;
    TextView tvSubtractResult;
    TextView tvMultiplyResult;
    TextView tvDivideResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        try {
            Bundle bundle = getIntent().getExtras();
            String one = bundle.getString("one");
            String two = bundle.getString("two");

            Counter counter = new Counter(one, two);

            tvAddResult = (TextView) findViewById(R.id.addResultTextView);
            tvAddResult.setText(one + " + " + two + " = " + counter.getAddResult());

            tvSubtractResult = (TextView) findViewById(R.id.subtractResultTextView);
            tvSubtractResult.setText(one + " - " + two + " = " + counter.getSubtractResult());

            tvMultiplyResult = (TextView) findViewById(R.id.multiplyResultTextView);
            tvMultiplyResult.setText(one + " * " + two + " = " + counter.getMultiplyResult());

            tvDivideResult = (TextView) findViewById(R.id.divideResultTextView);
            tvDivideResult.setText(one + " / " + two + " = " + counter.getDivideResult());
        }catch (NumberFormatException e){
            tvAddResult = (TextView) findViewById(R.id.addResultTextView);
            tvAddResult.setText("You have to enter number and click again");
            tvSubtractResult = (TextView) findViewById(R.id.subtractResultTextView);
            tvSubtractResult.setText("");
            tvMultiplyResult = (TextView) findViewById(R.id.multiplyResultTextView);
            tvMultiplyResult.setText("");
            tvDivideResult = (TextView) findViewById(R.id.divideResultTextView);
            tvDivideResult.setText("");
        }
    }
}
