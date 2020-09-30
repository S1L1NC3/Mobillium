package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.Category;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriesResponse extends BaseResponseObject {
    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @SerializedName("categories")
    @Expose
    private ArrayList<Category> categories;

}
