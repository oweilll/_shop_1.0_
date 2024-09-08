package com.example.class_work;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HelloWorld";
    Button nKnopka;//объявили кнопку
    Button onMe;//переход на новую активность
    EditText card_num;//номер карты на вторую активность
    EditText cvv_num;//cvv карты
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.e(TAG, "error in onStart");
        Log.w(TAG, "warning in onStart");
        Log.i("IKBO-32-22", "info in onStart");
        Log.d("IKBO-32-22", "debug in onStart");
        Log.v("IKBO-32-22", "verbuse in onStart");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nKnopka = findViewById(R.id.nKnopka);
        onMe = findViewById(R.id.onMe);
        nKnopka.setOnClickListener(this);
        card_num = findViewById(R.id.card_num);
        cvv_num = findViewById(R.id.cvv_num);




        //-----------------------------------------------//
        //test test = new test("3727 7273 2314 2149", "553");
        //Intent all_data = new Intent(this, me_activity.class);
        //all_data.putExtra("test", test);
        //-----------------------------------------------//
        onMe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "это второй", Toast.LENGTH_SHORT).show();
                String card_data = card_num.getText().toString();
                String cvv_data = cvv_num.getText().toString();

                Intent vtoroy = new Intent(MainActivity.this, me_activity.class);
                test testObject = new test(card_data, cvv_data);
                vtoroy.putExtra("test", testObject);
                startActivity(vtoroy);
            }
        });
        nKnopka.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "!!!", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("это какое то там окно")
                        .setMessage("тут должен быть какой то там текст")
                        .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(getApplicationContext(), "нононо", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v)
    {
    }
}