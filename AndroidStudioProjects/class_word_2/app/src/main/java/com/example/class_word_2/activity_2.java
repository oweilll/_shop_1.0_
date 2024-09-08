package com.example.class_word_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class activity_2 extends AppCompatActivity {

    TextView main_now;
    TextView info;

    Button next_to3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //TextView>>>>>>>>>>>>>>>>>>>>>>>>>>>
        main_now = findViewById(R.id.main_now);
        info = findViewById(R.id.info);

        //Button>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        next_to3 = findViewById(R.id.next_to3);
        Intent intent = getIntent();
        if(intent != null)
        {
            data_next data_nextObject = (data_next) intent.getSerializableExtra("activity2");
            if(data_nextObject != null)
            {
                main_now.setText(data_nextObject.getData_main());
            }
        }
        else Toast.makeText(this, "nononono", Toast.LENGTH_LONG).show();

        next_to3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_2.this, "Выберите дату", Toast.LENGTH_SHORT).show();
                Intent activity3 = new Intent(activity_2.this, activity_3.class);
                startActivity(activity3);
            }
        });
        Intent intent2 = getIntent();
        if(intent2 != null)
        {
            data_next data_nextObject = (data_next) intent2.getSerializableExtra("activitySec");
            if(data_nextObject != null)
            {
                String infoText = "День: " + data_nextObject.getDay() + "\nВремя: " + data_nextObject.getTime() + "\nКомментарий: " + data_nextObject.getComment();
                info.setText(infoText);
            }
        }


    }

}