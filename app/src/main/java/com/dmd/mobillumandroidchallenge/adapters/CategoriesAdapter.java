package com.dmd.mobillumandroidchallenge.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.CategoriesResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    private List<CategoriesResponse> mData;
    private LayoutInflater mInflater;

    public CategoriesAdapter(List<CategoriesResponse> mData) {
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
        holder.txtCategoryName.setText("mert");
        Picasso.get().load("https://d3fwvrpbsa6rxi.cloudfront.net/images/kadin-4337b90a-c39b-4efb-9f6d-9cb05e9ace6b.jpg")
                .into(holder.imgCategory);
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView txtCategoryName;
        ImageView imgCategory;

        CategoriesViewHolder(View itemView) {
            super(itemView);
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
