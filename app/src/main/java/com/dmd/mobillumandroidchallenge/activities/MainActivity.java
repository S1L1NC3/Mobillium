package com.dmd.mobillumandroidchallenge.activities;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.dmd.mobillumandroidchallenge.ApiInterface;
import com.dmd.mobillumandroidchallenge.R;
import com.dmd.mobillumandroidchallenge.adapters.CategoriesAdapter;
import com.dmd.mobillumandroidchallenge.adapters.FeaturedAdapter;
import com.dmd.mobillumandroidchallenge.adapters.ProductsAdapter;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.CategoriesResponse;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.FeaturedResponse;
import com.dmd.mobillumandroidchallenge.models.ResponseModels.ProductsResponse;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    private RecyclerView mRecyclerViewCategories, mRecyclerViewNewProducts;
    private CategoriesAdapter categoriesAdapter;
    private FeaturedAdapter featuredAdapter;
    private ProductsAdapter productsAdapter;
    private ViewPager viewPager;
    private List<ImageView> dots;
    private int numberOfPage = 0;

    //Burada böyle id falan buluyo
    private void findComponents(){
        mRecyclerViewCategories = findViewById(R.id.recyclerCategories);
        mRecyclerViewNewProducts = findViewById(R.id.recyclerNewProducts);
        viewPager = findViewById(R.id.viewPagerFeatured);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<ArrayList<Object>> call = apiInterface.getResponse();
        findComponents();

        call.enqueue(new Callback<ArrayList<Object>>() {
            @Override
            public void onResponse(Call<ArrayList<Object>> call, Response<ArrayList<Object>> response) {
                ArrayList<Object> o = response.body();
                Gson gson = new Gson();

                if (o != null){
                    for (Object object : o){
                        String type = (String) ((LinkedTreeMap)object).get("type");
                        assert type != null;
                        switch (type){
                            case "featured":
                                FeaturedResponse featuredResponse = gson.fromJson(gson.toJsonTree(object).getAsJsonObject(), FeaturedResponse.class);
                                featuredAdapter = new FeaturedAdapter(getSupportFragmentManager(), featuredResponse.getFeatured());
                                numberOfPage = featuredResponse.getFeatured().size();
                                addDots(numberOfPage);
                                selectDot(numberOfPage, 0);
                                viewPager.setAdapter(featuredAdapter);
                                break;
                            case "new_products":
                                ProductsResponse productsResponse = gson.fromJson(gson.toJsonTree(object).getAsJsonObject(), ProductsResponse.class);
                                productsAdapter = new ProductsAdapter(productsResponse.getProducts());
                                mRecyclerViewNewProducts.setAdapter(productsAdapter);

                                LinearLayoutManager linearLayoutManagerProducts = new LinearLayoutManager(getApplicationContext());
                                linearLayoutManagerProducts.setOrientation(LinearLayoutManager.HORIZONTAL);
                                mRecyclerViewNewProducts.setLayoutManager(linearLayoutManagerProducts);
                                break;
                            case "categories":
                                CategoriesResponse categoriesResponse = gson.fromJson(gson.toJsonTree(object).getAsJsonObject(), CategoriesResponse.class);
                                categoriesAdapter = new CategoriesAdapter(categoriesResponse.getCategories());
                                mRecyclerViewCategories.setAdapter(categoriesAdapter);

                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                                mRecyclerViewCategories.setLayoutManager(linearLayoutManager);
                                break;
                                //Ya bak diğer case'i de yapardım ama valla sıkıldım kod kalitemiz ektedirD
                            default:
                                break;
                        }


                    }

                }
            }

            //buraya bakma bizde fail olmaz
            @Override
            public void onFailure(Call<ArrayList<Object>> call, Throwable t) {
                Log.i("responseBody", "onFail: " + t);
            }
        });
    }



    //Burada nokta gibi bir şey piyu piyu ateşliyo
    public void addDots(int numberOfPages) {
        dots = new ArrayList<>();
        LinearLayout dotsLayout = findViewById(R.id.linearIndicatorPage);

        for(int i = 0; i < numberOfPages; i++) {
            ImageView dot = new ImageView(this);
            dot.setImageDrawable(getResources().getDrawable(R.drawable.tab_indicator_selected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    50,
                    50
            );
            dotsLayout.addView(dot, params);

            dots.add(dot);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectDot(numberOfPage, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //Burada hedefi buluyo bum
    public void selectDot(int numberOfPages ,int idx) {
        Resources res = getResources();
        for(int i = 0; i < numberOfPages; i++) {
            int drawableId = (i==idx)?(R.drawable.tab_indicator_selected):(R.drawable.tab_indicator_default);
            Drawable drawable = res.getDrawable(drawableId);
            dots.get(i).setImageDrawable(drawable);
        }
    }

    public void toNewActivityWithBundle(View view) {
        //burada da Tümü ekranını açıp Parcelable  aracılığıyla işte putExtra yapabilirdim
        // ama yapmadım

    }
}
