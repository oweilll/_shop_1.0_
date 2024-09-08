package com.example.a4pracwork;

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

public class MainActivity extends AppCompatActivity {

    EditText fio;
    Button next_to_fio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next_to_fio = findViewById(R.id.next_to_fio);
        next_to_fio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText textName = findViewById(R.id.fio);
                String fio = textName.getText().toString();
                Intent vtoroy = new Intent(MainActivity.this, activity_2.class);
                vtoroy.putExtra("fio", fio);
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
                            EditText editText = findViewById(R.id.fio);
                            if(result.getResultCode() == Activity.RESULT_OK)
                            {
                                Intent vtoroy = result.getData();
                                String accessMessage = vtoroy.getStringExtra(ACCESS_MESSAGE);
                                editText.setText(accessMessage);
                            }

                        }
                    });
}