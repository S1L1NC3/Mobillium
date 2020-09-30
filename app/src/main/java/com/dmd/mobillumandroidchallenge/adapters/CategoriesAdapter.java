package com.dmd.mobillumandroidchallenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private ArrayList<Category> mData;
    private LayoutInflater mInflater;

    public CategoriesAdapter(ArrayList<Category> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoriesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        holder.txtCategoryName.setText(mData.get(position).getName());
        Picasso.get().load(mData.get(position).getLogo().getUrl()).into(holder.imgNewProduct);
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategoryName;
        ImageView imgNewProduct;

        CategoriesViewHolder(View itemView) {
            super(itemView);
            imgNewProduct = itemView.findViewById(R.id.imgCategory);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
