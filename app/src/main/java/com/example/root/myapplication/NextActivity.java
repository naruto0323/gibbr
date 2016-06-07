package com.example.root.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import android.view.View.OnClickListener;

/**
 * Created by root on 7/6/16.
 */
public class NextActivity extends Activity {
    int clickcount=0;
    private static final String TAG = "CS65";
    String[] temp_array;
    private int[] temp_id=new int[100];
    private String[] toppings;
    private String temp[];
    private String[] strings;
    Button b2;
    int p=0;

    private static final Pattern TAG_REGEX = Pattern.compile("<(\\S+)>");
    final List<String> tagValues = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        //Find the directory for the SD Card using the API
//*Don't* hardcode "/sdcard"
        File sdcard = Environment.getExternalStorageDirectory();

//Get the text file
        File file = new File(sdcard,"gibbr_fill.txt");

//Read text from file
        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int cou=0;
            while ((line = br.readLine()) != null) {
                text.append(line);
                cou++;
                if(cou==1) {
                    text.append(" ");
                }
            }
            br.close();
        }
        catch (IOException e) {
            //You'll need to add proper error handling here
        }
        temp_array=text.toString().split(" ");
        int t=0;
        for(String name:temp_array) {
            t++;
            if (name.charAt(0) == '<')
            {
//                Log.d(TAG, "onCreate() No saved state available"+name);

                temp_id[p]=t-1;
                p++;
//                Log.d(TAG, "onCreate() No saved state available" +name);

            }
//            Log.d(TAG, "onCreate() No saved state available" +name);
//        strings = tagValues.toArray(strings);//now strings is the resulting array
        }

//Find the view by its id
        TextView tv = (TextView)findViewById(R.id.editText);

//Set the text
        tv.setText(temp_array[temp_id[0]]);



//        final Button b2 = (Button) findViewById(R.id.button1);


    }
    public void myhandler1(View view)
    {        TextView inp = (TextView) findViewById(R.id.editText);

        String input = inp.getText().toString();

        if(clickcount==p-1)
        {
            temp_array[temp_id[clickcount++]]=input;
            Intent myIntent = new Intent(NextActivity.this, Final.class);
            myIntent.putExtra("mylist", temp_array);
            NextActivity.this.startActivity(myIntent);

        }
        Log.d(TAG, "onCreate() No saved state available"+clickcount);


        temp_array[temp_id[clickcount++]]=input;
        Log.d(TAG, "onCreate() No saved state available"+temp_array[temp_id[clickcount-1]]);
        inp.setText(temp_array[temp_id[clickcount]]);
    }

}


