package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.Featured;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FeaturedResponse extends BaseResponseObject {
    public ArrayList<Featured> getFeatured() {
        return featured;
    }

    public void setFeatured(ArrayList<Featured> featured) {
        this.featured = featured;
    }

    @SerializedName("featured")
    @Expose
    private ArrayList<Featured> featured;
}
