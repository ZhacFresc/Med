package com.example.Kak_voobshe_eto_delat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MedAPI {

    @GET("0090ce04-e1b9-487c-9f1e-9b35b3b26e99")
    Call<List<News>> getNews();

    @GET("532c2674-f536-4b93-bd65-0a51d4de174d")
    Call<List<Catalog>> getCatalog();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create()).build();
}
