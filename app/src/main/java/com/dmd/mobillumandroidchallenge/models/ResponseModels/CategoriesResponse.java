package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.Category;
import com.dmd.mobillumandroidchallenge.models.Featured;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponse extends BaseResponseObject {
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @SerializedName("categories")
    @Expose
    private List<Category> categories;

}
