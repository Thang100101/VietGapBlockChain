package com.example.ofood.API;

import com.example.ofood.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("products")
    Call<List<Product>> getProductByBarcode(@Query("productCode") String barcode);
    @GET("products")
    Call<Product> getProductById(@Query("id") int id);
}
