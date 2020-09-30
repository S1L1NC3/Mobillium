package com.dmd.mobillumandroidchallenge.activities;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;
    private static String Base_Url= "https://www.vitrinova.com/api/v2/";

    public static Retrofit getClient(){
        if(retrofit== null){retrofit = new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build();
            return retrofit;    }
        return retrofit;
    }
}
