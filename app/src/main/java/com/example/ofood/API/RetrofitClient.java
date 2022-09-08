package com.example.ofood.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String baseUrl = "http://thangvuproduct.herokuapp.com/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            return getRetrofitInstance();
        }
        return retrofit;
    }

    private synchronized static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
            return retrofit;
        }
        return retrofit;
    }
}
