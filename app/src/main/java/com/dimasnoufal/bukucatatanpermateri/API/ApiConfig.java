package com.dimasnoufal.bukucatatanpermateri.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    //    static final String BASE_URL = "https://rickandmortyapi.com/api/";
    static final String BASE_URL = "https://story-api.dicoding.dev/v1/";

    public static Retrofit getApiConfig() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService service = getApiConfig().create(ApiService.class);
}
