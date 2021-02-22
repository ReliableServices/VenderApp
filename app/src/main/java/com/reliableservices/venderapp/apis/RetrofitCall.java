package com.reliableservices.venderapp.apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reliableservices.venderapp.common.Common;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCall {
    public static ApiInterface getApi(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit r = new Retrofit.Builder().baseUrl(Common.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        return r.create(ApiInterface.class);
    }
}
