package com.example.abuzar.assignment02;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences settings = getSharedPreferences("MYPREFRENCE", Context.MODE_PRIVATE);
        String getusername = settings.getString("usernamesend", "");
        TextView tv=(TextView)findViewById(R.id.textView2);
        tv.setText(getusername);
    }
}
