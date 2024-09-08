package com.example.magazin;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AddProductFragment extends Fragment {

    private EditText editTextProductName;
    private EditText editTextProductPrice;
    private EditText editTextProductImage;
    private Button buttonAddProduct;
    private DatabaseHelper dbHelper;

    public AddProductFragment()
    {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        editTextProductName = view.findViewById(R.id.edit_text_product_name);
        editTextProductPrice = view.findViewById(R.id.edit_text_product_price);
        editTextProductImage = view.findViewById(R.id.edit_text_product_image);
        buttonAddProduct = view.findViewById(R.id.button_add_product);

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductToDatabase();
            }
        });

        return view;
    }

    private void addProductToDatabase() {
        String name = editTextProductName.getText().toString().trim();
        String priceStr = editTextProductPrice.getText().toString().trim();
        String image = editTextProductImage.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(priceStr) || TextUtils.isEmpty(image)) {
            Toast.makeText(getActivity(), "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            Toast.makeText(getActivity(), "Неверная цена", Toast.LENGTH_SHORT).show();
            return;
        }

        dbHelper.addProduct(name, price, image);
        Toast.makeText(getActivity(), "Продукт добавлен", Toast.LENGTH_SHORT).show();

        // Clear the input fields
        editTextProductName.setText("");
        editTextProductPrice.setText("");
        editTextProductImage.setText("");
    }
}
