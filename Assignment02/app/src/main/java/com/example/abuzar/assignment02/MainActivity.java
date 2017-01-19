package com.example.abuzar.assignment02;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DBClass dbClassobj=new DBClass(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbClassobj.insertData();
    }
    public void loginfun(View view){
        EditText TextUsername=(EditText)findViewById(R.id.editText);
        String usernamestring=TextUsername.getText().toString();
        EditText TextPassword=(EditText)findViewById(R.id.editText2);
        String passwordstring=TextPassword.getText().toString();

        SharedPreferences settings = getSharedPreferences("MYPREFRENCE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        String password = dbClassobj.AuthenticationFun(usernamestring);
        if (passwordstring.equals(password)){

            Intent i=new Intent(MainActivity.this,WelcomeActivity.class);
            editor.putString("usernamesend", usernamestring);
            editor.apply();
            startActivity(i);
        }else {
            Toast toast=Toast.makeText(MainActivity.this,"Username or Password Incorrect",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
