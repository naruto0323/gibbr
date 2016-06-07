package com.example.root.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View.OnClickListener myhandler = new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NextActivity.class);
                MainActivity.this.startActivity(myIntent);

                // it was the 1st button
            }
        };
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(myhandler);
    }

}
