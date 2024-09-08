package com.example.a4pracwork;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

public class activity_2 extends AppCompatActivity {
    TextView fio_2;
    Button back;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        back = findViewById(R.id.back);
        Bundle arguments = getIntent().getExtras();
        if(arguments.get("fio") != null)
        {
            @SuppressLint("WrongViewCast")
            TextView editText = findViewById(R.id.fio_2);
            String name = arguments.get("fio").toString();
            editText.setText(name);
            saveText(name);
        }
        if(arguments.get("day") != null)
        {
            TextView date_one = findViewById(R.id.alll);
            String date = arguments.get("day").toString();
            String time = arguments.get("time").toString();
            String comment = arguments.get("comment").toString();
            date_one.setText("Дата записи:" + date + "\n Время записи:" + time + "\n Комментарий к записи:" + comment);
        }
        openText();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent trtiy = new Intent(activity_2.this, activity_3.class);
                startActivity(trtiy);
            }
        });
    }

    public void saveText(String name)
    {
        FileOutputStream fos = null;
        try
        {
            String filename = "fio.txt";
            String text = name;
            fos = openFileOutput(filename , MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fos!= null)
                    fos.close();
            }
            catch (IOException ex)
            {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }





    public void openText()
    {
        FileInputStream fin = null;
        TextView textView = findViewById(R.id.fio_2);

        try
        {
            String fileName = "fio.txt";
            fin = openFileInput(fileName);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            textView.setText(text);
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try
            {
                if (fin != null)
                    fin.close();
            }
            catch(IOException ex)

                {
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



    //<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>
