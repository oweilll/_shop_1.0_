package com.example.a5practwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Пример данных
        List<Item> items = new ArrayList<>();
        items.add(new Item("Элемент 1", R.drawable.ic_launcher_foreground));
        items.add(new Item("Элемент 2", R.drawable.ic_launcher_foreground));
        items.add(new Item("Элемент 3", R.drawable.ic_launcher_foreground));

        SimpleAdapter adapter = new SimpleAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}
