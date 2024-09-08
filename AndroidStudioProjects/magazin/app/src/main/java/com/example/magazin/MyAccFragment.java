package com.example.magazin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyAccFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public MyAccFragment() {
    }

    public static MyAccFragment newInstance(String param1) {
        MyAccFragment fragment = new MyAccFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_acc, container, false);

        TextView textViewUsername = view.findViewById(R.id.textViewUsername);
        textViewUsername.setText(mParam1);
        String customerCardNumber = getCustomerCardNumber(mParam1);
        TextView textViewCustomerCard = view.findViewById(R.id.textViewCustomerCard);
        textViewCustomerCard.setText("Карта лояльности Бoev Store " + (customerCardNumber != null ? customerCardNumber : "No Card"));

        TextView textViewLoyaltyMessage = view.findViewById(R.id.textViewLoyaltyMessage);

        if (customerCardNumber != null) {
            textViewLoyaltyMessage.setVisibility(View.VISIBLE);
        } else {
            textViewLoyaltyMessage.setVisibility(View.GONE);
        }

        return view;
    }

    private String getCustomerCardNumber(String username) {
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        return dbHelper.getUserCardNumber(username);
    }
}
