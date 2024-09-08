package com.example.class_work;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.w3c.dom.Text;

public class me_activity extends AppCompatActivity {

    private TextView card_num_p;
    private TextView cvv_num_p;
    Button nazad_me;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        card_num_p = findViewById(R.id.card_num_p);
        cvv_num_p = findViewById(R.id.cvv_num_p);

        Intent intent = getIntent();
        if (intent != null) {
            test testObject = (test) intent.getSerializableExtra("test");
            if (testObject != null) {
                card_num_p.setText(testObject.getCard_num());
                cvv_num_p.setText(testObject.getCvv_num());
            }
        }



        nazad_me = findViewById(R.id.nazad_me);
        nazad_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(me_activity.this, "Назад!!!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}