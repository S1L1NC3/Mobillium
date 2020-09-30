package com.dmd.mobillumandroidchallenge.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.dmd.mobillumandroidchallenge.ApiInterface;
import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.adapters.CategoriesAdapter;
import com.dmd.mobillumandroidchallenge.adapters.FeaturedAdapter;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.FeaturedResponse;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    private RecyclerView mRecyclerViewCategories;
    private CategoriesAdapter mAdapter;
    private FeaturedAdapter featuredAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Object> call = apiInterface.getResponse();




        mRecyclerViewCategories = findViewById(R.id.recyclerCategories);
        viewPager = findViewById(R.id.viewPagerFeatured);
        mAdapter = new CategoriesAdapter(null);
        mRecyclerViewCategories.setAdapter(mAdapter);
        featuredAdapter = new FeaturedAdapter(null, getApplicationContext());
        //viewPager.setAdapter(featuredAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewCategories.setLayoutManager(linearLayoutManager);


        /*
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object o = response.body();
                Gson gson = new Gson();
                String jsonString = gson.toJson(response.body());

                Log.i("responseBody", "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.i("responseBody", "onFail: " + t);
            }
        });
*/
    }
}
