package com.example.a4pracwork;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_3 extends AppCompatActivity {
    Button zapis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        zapis = findViewById(R.id.zapis);

        zapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText textName = findViewById(R.id.day);
                EditText textName1 = findViewById(R.id.time);
                EditText textName2 = findViewById(R.id.comment);
                String time = textName1.getText().toString();
                String comment = textName2.getText().toString();
                String day = textName.getText().toString();
                Intent vtoroy = new Intent(activity_3.this, activity_2.class);
                vtoroy.putExtra("day", day);
                vtoroy.putExtra("time", time);
                vtoroy.putExtra("comment", comment);
                mStartForResult.launch(vtoroy);
            }
        });

    }


    static final String ACCESS_MESSAGE = "ACCESS_MESSAGE";
    ActivityResultLauncher<Intent> mStartForResult =
            registerForActivityResult(new
                            ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result)
                        {
                            EditText editText = findViewById(R.id.day);
                            if(result.getResultCode() == Activity.RESULT_OK)
                            {
                                Intent vtoroy = result.getData();
                                String accessMessage = vtoroy.getStringExtra(ACCESS_MESSAGE);
                                editText.setText(accessMessage);
                            }

                        }
                    });

}