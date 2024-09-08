package com.example.a5pracwork;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class activity_2 extends AppCompatActivity {
    ListView itemList;
    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    String category;
    EditText newItemEditText;
    Button addButton, removeButton;
    TextView selectedFruitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        category = getIntent().getStringExtra("category");
        setTitle(category);

        selectedFruitTextView = findViewById(R.id.selected_fruit);
        selectedFruitTextView.setText("выбранный фрукт: " + category);

        itemList = findViewById(R.id.item_list);
        newItemEditText = findViewById(R.id.new_item);
        addButton = findViewById(R.id.add_button);
        removeButton = findViewById(R.id.remove_button);

        items = new ArrayList<>();
        switch (category) {
            case "Яблоки":
                items.add("мелба");
                items.add("антоновка");
                items.add("фуджи");
                break;
            case "Бананы":
                items.add("банан 1");
                items.add("банан 2");
                items.add("банан 3");
                break;
            case "Груши":
                items.add("груша какая то");
                items.add("груша еще какая то");
                items.add("груша боск");
                break;
            case "Виноград":

                items.add("красный виноград");
                items.add("зеленый виноград");
                break;
            case "Апельсины":
                items.add("валенсия");
                items.add("мини");

                break;
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        itemList.setAdapter(adapter);
        itemList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = newItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    items.add(newItem);
                    adapter.notifyDataSetChanged();
                    newItemEditText.setText("");
                } else {
                    Toast.makeText(activity_2.this, "Введите название нового элемента", Toast.LENGTH_SHORT).show();
                }
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = itemList.getCount() - 1; i >= 0; i--) {
                    if (itemList.isItemChecked(i)) {
                        items.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
                itemList.clearChoices();
            }
        });
    }
}
