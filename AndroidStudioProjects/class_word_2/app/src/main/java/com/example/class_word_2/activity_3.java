package com.example.class_word_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_3 extends AppCompatActivity {

    EditText day;
    EditText time;
    EditText comment;
    Button back_to2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        day = findViewById(R.id.day);
        time = findViewById(R.id.time);
        comment = findViewById(R.id.comment);
        back_to2 = findViewById(R.id.back_to2);

        back_to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String day_next = day.getText().toString();
                String time_next = time.getText().toString();
                String comment_next = comment.getText().toString();

                Intent activity2 = new Intent(activity_3.this, activity_2.class);

                data_next data_nextObject = new data_next(day_next, time_next, comment_next);

                activity2.putExtra("activitySec", data_nextObject);
                activity2.putExtra("activity2", data_nextObject);
                startActivity(activity2);

            }
        });


    }
}