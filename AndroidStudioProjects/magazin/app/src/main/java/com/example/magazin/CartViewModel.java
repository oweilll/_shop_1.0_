package com.example.magazin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class CartViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<Product>> cartProducts = new MutableLiveData<>(new ArrayList<>());

    public LiveData<ArrayList<Product>> getCartProducts() {
        return cartProducts;
    }

    public void addProductToCart(Product product) {
        ArrayList<Product> currentProducts = cartProducts.getValue();
        if (currentProducts != null) {
            currentProducts.add(product);
            cartProducts.setValue(currentProducts);
        }
    }
}
