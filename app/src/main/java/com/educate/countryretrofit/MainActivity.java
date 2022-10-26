package com.educate.countryretrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.educate.countryretrofit.adapter.RecyclerAdapter;
import com.educate.countryretrofit.model.CountryModel;
import com.educate.countryretrofit.model.Result;
import com.educate.countryretrofit.service.GetCountries;
import com.educate.countryretrofit.service.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<CountryModel> countryModels;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetCountry();
    }

    private Object GetCountry() {
        GetCountries countries = RetrofitInstance.getService();
        Call<Result> resultCall = countries.getCountry();
        resultCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if (result != null && result.getResult() != null) {
                    countryModels = (ArrayList<CountryModel>) result.getResult();


                    for (CountryModel c : result.getResult()) {
                        Log.v("TAG", c.getName());
                    }
                    ShowInListItem();

                }

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return countryModels;
    }

    private void ShowInListItem() {
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(manager);
        adapter = new RecyclerAdapter(countryModels);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


    }
}