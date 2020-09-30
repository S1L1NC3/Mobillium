package com.dmd.mobillumandroidchallenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {
    private ArrayList<Product> mData;
    private LayoutInflater mInflater;

    public ProductsAdapter(ArrayList<Product> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_product, parent, false);
        return new ProductsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Picasso.get().load(mData.get(position).getImages().get(0).getUrl()).into(holder.imgNewProduct);
        holder.txtNewProductName.setText(mData.get(position).getTitle());
        holder.txtNewProductShopName.setText(mData.get(position).getShop().getName());
        String priceString = mData.get(position).getPrice() + " TL";
        holder.txtNewProductPrice.setText(priceString);
    }

    public static class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView txtNewProductName, txtNewProductShopName, txtNewProductPrice;
        ImageView imgNewProduct;

        ProductsViewHolder(View itemView) {
            super(itemView);
            imgNewProduct = itemView.findViewById(R.id.imgNewProduct);
            txtNewProductName = itemView.findViewById(R.id.txtNewProductName);
            txtNewProductShopName = itemView.findViewById(R.id.txtNewProductShopName);
            txtNewProductPrice = itemView.findViewById(R.id.txtNewProductPrice);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
