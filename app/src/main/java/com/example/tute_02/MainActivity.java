package com.example.tute_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okButton = (Button) findViewById(R.id.okBtn);

        final EditText num01 = (EditText) findViewById(R.id.number01);
        final EditText num02 = (EditText) findViewById(R.id.number02);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent okIntent = new Intent(MainActivity.this, Second.class);

                String n1 = num01.getText().toString();
                String n2 = num02.getText().toString();

                okIntent.putExtra("EXTRA1", n1);
                okIntent.putExtra("EXTRA2", n2);

                Context context = getApplicationContext();
                CharSequence message = "Data received";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();

                startActivity(okIntent);
            }
        });

        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.custom_toast, (ViewGroup)
                findViewById(R.id.resultShowLayout));

        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();
    }
}
