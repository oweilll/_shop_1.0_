package com.example.a5pracwork;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Name> names = new ArrayList<>();
    ListView nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();

        nameList = findViewById(R.id.my_list);
        NameAdapter nameAdapter = new NameAdapter(this, R.layout.list_item, names);
        nameList.setAdapter(nameAdapter);

        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Name selectedName = (Name) parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, activity_2.class);
                intent.putExtra("category", selectedName.getName());
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {
        names.add(new Name("Яблоки", "Фрукты"));
        names.add(new Name("Бананы", "Фрукты"));
        names.add(new Name("Груши", "Фрукты"));
        names.add(new Name("Виноград", "Фрукты"));
        names.add(new Name("Апельсины", "Фрукты"));
    }

    public class NameAdapter extends ArrayAdapter<Name> {
        private LayoutInflater inflater;
        private int layout;
        private ArrayList<Name> names;

        public NameAdapter(MainActivity context, int resource, ArrayList<Name> names) {
            super(context, resource, names);
            this.names = names;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(this.layout, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Name name = names.get(position);
            viewHolder.nameView.setText(name.getName());
            viewHolder.surnameView.setText(name.getSurname());

            return convertView;
        }

        private class ViewHolder {
            final TextView nameView, surnameView;

            ViewHolder(View view) {
                nameView = view.findViewById(R.id.name);
                surnameView = view.findViewById(R.id.surname);
            }
        }
    }
}
