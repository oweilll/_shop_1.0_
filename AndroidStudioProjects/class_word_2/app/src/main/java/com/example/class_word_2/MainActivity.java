package com.example.class_word_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button next_on2;
    EditText data_main;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        next_on2 = findViewById(R.id.next_on2);

        //EditText>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        data_main = findViewById(R.id.data_main);



        //----------------------------------------------------//

        next_on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Отправлено", Toast.LENGTH_SHORT).show();
                String dataNext = data_main.getText().toString();
                Intent activity2 = new Intent(MainActivity.this, activity_2.class);
                data_next data_nextObject = new data_next(dataNext);
                activity2.putExtra("activity2", data_nextObject);
                startActivity(activity2);
            }
        });

    }


    public void onClick() {

    }
}
