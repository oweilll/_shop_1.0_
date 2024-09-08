package com.example.a5pracwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class NameAdapter extends ArrayAdapter<Name>
{
    private LayoutInflater inflater;
    private int layout;
    private List<Name> names;

    public NameAdapter(Context context, int resource, List<Name> name)
    {
        super(context, resource, name);
        this.names = name;
        this.layout = resource;
        this.inflater=LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(this.layout, parent, false);
        TextView nameView = view.findViewById(R.id.name);
        TextView surnameView = view.findViewById(R.id.surname);
        Name name = names.get(position);

        nameView.setText(name.getName());
        surnameView.setText(name.getSurname());
        return view;
    }
}