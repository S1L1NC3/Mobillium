package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.ShopWithPopularProducts;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopsResponse extends BaseResponseObject {
    @SerializedName("shops")
    @Expose
    private List<ShopWithPopularProducts> shops;

    public List<ShopWithPopularProducts> getShops() {
        return shops;
    }

    public void setShops(List<ShopWithPopularProducts> shops) {
        this.shops = shops;
    }
}
