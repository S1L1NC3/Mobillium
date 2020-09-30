package com.dmd.mobillumandroidchallenge.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dmd.mobillumandroidchallenge.models.Featured;

import java.util.ArrayList;

public class FeaturedAdapter extends FragmentPagerAdapter {
    ArrayList<Featured> featuredArrayList;
    public FeaturedAdapter(FragmentManager fragmentManager,ArrayList<Featured> featuredArrayList){
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.featuredArrayList = featuredArrayList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FeatureFragment.newInstance(featuredArrayList.get(position));
    }

    @Override
    public int getCount() {
        return featuredArrayList.size();
    }
}
