package com.dmd.mobillumandroidchallenge;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("discover")
    Call<Object> getResponse();
}
