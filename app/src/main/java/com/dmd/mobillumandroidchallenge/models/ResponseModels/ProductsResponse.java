package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductsResponse extends BaseResponseObject {
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @SerializedName("products")
    @Expose
    private ArrayList<Product> products;
}
