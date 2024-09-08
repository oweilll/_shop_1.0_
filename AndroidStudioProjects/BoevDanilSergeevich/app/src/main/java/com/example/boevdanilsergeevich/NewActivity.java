package com.example.boevdanilsergeevich;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private static final String TAG = "NewAcitivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new);
        Log.d(TAG, "onCreate() вызван");
        TextView messageText = findViewById(R.id.messageText);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null && arguments.containsKey("name") && arguments.containsKey("age") && arguments.containsKey("gang") && arguments.containsKey("num")) {
            String name = arguments.getString("name");
            String gang = arguments.getString("gang");
            int age = arguments.getInt("age");
            String num = arguments.getString("num");
            messageText.setText("Имя: " + name + "\nГруппа: " + gang + "\nВозраст: " + age + "\nОценка: " + num);
        } else {
            messageText.setText("Данные отсутствуют или некорректны");
        }


        //3


    }
    public void onBack()
    {
        Intent intent = new Intent(this, MainActivity.class);
        Log.d(TAG, "OnBACK");
    }

}
