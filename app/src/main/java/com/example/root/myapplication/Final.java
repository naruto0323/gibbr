package com.example.root.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by root on 7/6/16.
 */
public class Final extends Activity {
    private static final String TAG = "CS65";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        String[] myList = (String[]) getIntent().getSerializableExtra("mylist");
        TextView tv = (TextView)findViewById(R.id.textView2);

//Set the text
        int arraySize = myList.length;
        for(int i = 0; i < arraySize; i++) {
            tv.append(myList[i]);
            tv.append(" ");

//        tv.setText(myList.toString());
            Log.d(TAG, "onCreate() No saved state available" + myList[i]);
        }

    }
}
