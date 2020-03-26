package com.example.tute_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Second extends AppCompatActivity {
    String takeExtra1;
    String takeExtra2;
    String n1;
    String n2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button backButton = (Button) findViewById(R.id.backBtn);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        Button minusBtn = (Button) findViewById(R.id.minusBtn);
        Button multyBtn = (Button) findViewById(R.id.multyBtn);
        Button divideBtn = (Button) findViewById(R.id.divideBtn);

        final TextView resultView = (TextView) findViewById(R.id.result);

        Intent getIntent = getIntent();

        EditText number01 = (EditText) findViewById(R.id.num01);
        EditText number02 = (EditText) findViewById(R.id.num02);

        takeExtra1 = getIntent.getStringExtra("EXTRA1");
        takeExtra2 = getIntent.getStringExtra("EXTRA2");

        number01.setText(takeExtra1);
        number02.setText(takeExtra2);

        n1 = number01.getText().toString();
        n2 = number02.getText().toString();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.parseDouble(takeExtra1) + Double.parseDouble(takeExtra2);
                resultView.setText(Double.toString(result));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.parseDouble(takeExtra1) - Double.parseDouble(takeExtra2);
                resultView.setText(Double.toString(result));
            }
        });

        multyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.parseDouble(takeExtra1) * Double.parseDouble(takeExtra2);
                resultView.setText(Double.toString(result));
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Double.parseDouble(takeExtra1) / Double.parseDouble(takeExtra2);
                resultView.setText(Double.toString(result));
            }
        });

//        Manage back Button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Second.this, MainActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
