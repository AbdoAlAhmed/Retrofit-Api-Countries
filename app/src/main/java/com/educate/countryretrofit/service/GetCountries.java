package com.educate.countryretrofit.service;

import com.educate.countryretrofit.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountries {

    @GET("countries")
    Call<Result> getCountry();
}
