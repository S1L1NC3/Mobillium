package com.dmd.mobillumandroidchallenge.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.models.Featured;
import com.squareup.picasso.Picasso;

public class FeatureFragment extends Fragment {

    private static final String FEATURE = "FEATURE";

    private Featured featured;

    public FeatureFragment() {
        // Required empty public constructor
    }

    public static FeatureFragment newInstance(Featured featured) {
        FeatureFragment fragment = new FeatureFragment();
        Bundle args = new Bundle();
        args.putSerializable(FEATURE, featured);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            featured = (Featured) getArguments().getSerializable(FEATURE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_feature, container, false);
        TextView txtFeaturedName = v.findViewById(R.id.txtFeaturedName);
        TextView txtFeaturedHeader = v.findViewById(R.id.txtFeaturedHeader);
        ImageView imgFeatured = v.findViewById(R.id.imgFeatured);
        Picasso.get().load(featured.getCover().getUrl()).into(imgFeatured);
        txtFeaturedHeader.setText(featured.getTitle());
        txtFeaturedName.setText(featured.getSubTitle());
        return v;
    }
}