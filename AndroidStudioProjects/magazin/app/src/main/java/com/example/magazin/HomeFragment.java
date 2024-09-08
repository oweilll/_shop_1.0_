package com.example.magazin;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private DatabaseHelper dbHelper;
    private ProductAdapter productAdapter;
    private RecyclerView recyclerView;
    private EditText searchEditText;
    private CartViewModel cartViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DatabaseHelper(getActivity());
        cartViewModel = new ViewModelProvider(requireActivity()).get(CartViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchEditText = view.findViewById(R.id.search_edit_text);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        loadProducts();

        return view;
    }

    private void loadProducts() {
        ArrayList<Product> productList = new ArrayList<>();
        Cursor cursor = dbHelper.getReadableDatabase().query(DatabaseHelper.TABLE_PRODUCTS, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_ID);
                int nameIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_NAME);
                int priceIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_PRICE);
                int imageIndex = cursor.getColumnIndex(DatabaseHelper.COLUMN_PRODUCT_IMAGE);

                if (idIndex != -1 && nameIndex != -1 && priceIndex != -1 && imageIndex != -1) {
                    int id = cursor.getInt(idIndex);
                    String name = cursor.getString(nameIndex);
                    int price = cursor.getInt(priceIndex);
                    String image = cursor.getString(imageIndex);
                    productList.add(new Product(id, name, price, image));
                } else {
                    Log.e("HomeFragment", "Error: Column index not found");
                }
            } while (cursor.moveToNext());
            cursor.close();
        }

        productAdapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(productAdapter);
    }

    private void filterProducts(String query) {
        ArrayList<Product> filteredList = new ArrayList<>();
        for (Product product : productAdapter.getProductList()) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }
        productAdapter.filterList(filteredList);
    }

    public void addProductToCart(Product product) {
        cartViewModel.addProductToCart(product);
    }
}
