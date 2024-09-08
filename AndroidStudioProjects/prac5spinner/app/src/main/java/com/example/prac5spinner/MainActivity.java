package com.example.prac5spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prac5spinner.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        final TextView selectedItemText = findViewById(R.id.selected_item_text);


        String[] items = {"Продукт 1", "Пррдукт 2", "Продукт 3", "Продукт 4", "Продукт 5"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

       //слушатель
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //элемент>>>>>
                String selectedItem = parent.getItemAtPosition(position).toString();

                selectedItemText.setText("Выбранный элемент: " + selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // если ничего не выбрано
                selectedItemText.setText("Ничего не выбрано");
            }
        });
    }
}
