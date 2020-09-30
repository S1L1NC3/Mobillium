package com.dmd.mobillumandroidchallenge.activities;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if(retrofit== null){
            String base_Url = "https://www.vitrinova.com/api/v2/";
            retrofit = new Retrofit.Builder()
                .baseUrl(base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
            return retrofit;    }
        return retrofit;
    }
}
