package com.dmd.mobillumandroidchallenge.models.ResponseModels;

import com.dmd.mobillumandroidchallenge.models.BaseResponseObject;
import com.dmd.mobillumandroidchallenge.models.CollectionObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollectionsResponse extends BaseResponseObject {
    public List<CollectionObject> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionObject> collections) {
        this.collections = collections;
    }

    @SerializedName("collections")
    @Expose
    private List<CollectionObject> collections;
}
