package com.dmd.mobillumandroidchallenge;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("discover")
    Call<ArrayList<Object>> getResponse();
}
