package com.example.magazin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class AdminFragment extends Fragment {

    private TextView textViewWelcome;
    private Button buttonAddProduct;
    private Button buttonDeleteProduct;
    private EditText editTextProductId;
    private DatabaseHelper databaseHelper;

    public AdminFragment() {
    }

    public static AdminFragment newInstance() {
        return new AdminFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        textViewWelcome = view.findViewById(R.id.textViewWelcome);
        buttonAddProduct = view.findViewById(R.id.buttonAddProduct);
        buttonDeleteProduct = view.findViewById(R.id.buttonDeleteProduct);
        editTextProductId = view.findViewById(R.id.editTextProductId);

        textViewWelcome.setText("Вы вошли как админ");

        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment favoriteFragment = new AddProductFragment();
                Toast.makeText(getActivity(), "Это меню для добавления продуктов", Toast.LENGTH_SHORT).show();

                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, favoriteFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        buttonDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productIdStr = editTextProductId.getText().toString().trim();
                if (!productIdStr.isEmpty()) {
                    int productId = Integer.parseInt(productIdStr);
                    deleteProduct(productId);
                } else {
                    Toast.makeText(getActivity(), "Введите ID продукта для удаления", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void deleteProduct(int productId) {
        databaseHelper.deleteProduct(productId);
        Toast.makeText(getActivity(), "Продукт с ID " + productId + " удален", Toast.LENGTH_SHORT).show();
    }
}
