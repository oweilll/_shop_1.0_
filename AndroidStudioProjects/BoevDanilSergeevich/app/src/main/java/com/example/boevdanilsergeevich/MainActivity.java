package com.example.boevdanilsergeevich;

import androidx.appcompat.app.AppCompatActivity;


import android.nfc.Tag;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Hello_world";
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "eror");
        Log.w(TAG, "warning");
        Log.i(TAG, "info");
        Log.d(TAG, "debug");
        Log.v(TAG, "verbose");
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
    }

    protected void onClick(View view) {
        Toast.makeText(this, "кнопка нажата", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onClick");
    }

    // В MainActivity
    public void onNextActivity(View view) {
        EditText nameText = findViewById(R.id.name);
        EditText ageText = findViewById(R.id.age);
        EditText gangText = findViewById(R.id.gang);
        EditText numText = findViewById(R.id.num);

        String name = nameText.getText().toString();
        String ageString = ageText.getText().toString();
        String gang = gangText.getText().toString();
        String num = numText.getText().toString();
        Log.d(TAG, "onNextActivity");



        int age;

            age = Integer.parseInt(ageString);
            if (age <= 0) {
                throw new NumberFormatException();
            }


        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("gang", gang);
        intent.putExtra("num", num);
        startActivity(intent);



    }

}