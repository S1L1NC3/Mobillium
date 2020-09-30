package com.dmd.mobillumandroidchallenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.FeaturedResponse;

import java.util.List;

public class FeaturedAdapter extends PagerAdapter {
    private List<FeaturedResponse> featuredItems;
    private LayoutInflater layoutInflater;
    private Context context;

    public FeaturedAdapter(List<FeaturedResponse> featuredItems, Context context) {
        this.featuredItems = featuredItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.thumbnail_featured, container, false);
        TextView txtFeaturedName = view.findViewById(R.id.txtFeaturedName);
        TextView txtFeaturedHeader = view.findViewById(R.id.txtFeaturedHeader);
        ImageView imgFeatured = view.findViewById(R.id.imgFeatured);

        txtFeaturedName.setText("JEWELARİFY");
        txtFeaturedHeader.setText("Vitrin");
        container.addView(view,0);
        return super.instantiateItem(container, position);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
