package com.example.magazin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private ArrayList<Product> productList;
    private Fragment fragment;

    public ProductAdapter(ArrayList<Product> productList, Fragment fragment) {
        this.productList = productList;
        this.fragment = fragment;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void filterList(ArrayList<Product> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.nameTextView.setText(product.getName());
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
        Picasso.get().load(product.getImage()).into(holder.imageView);

        holder.addToCartButton.setOnClickListener(v -> {
            if (fragment instanceof HomeFragment) {
                ((HomeFragment) fragment).addProductToCart(product);
            } else if (fragment instanceof KorzinaFragment) {
                ((KorzinaFragment) fragment).addProductToCart(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView, priceTextView;
        public ImageView imageView;
        public Button addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.product_name);
            priceTextView = itemView.findViewById(R.id.product_price);
            imageView = itemView.findViewById(R.id.product_image);
            addToCartButton = itemView.findViewById(R.id.button_add_to_cart);
        }
    }
}
