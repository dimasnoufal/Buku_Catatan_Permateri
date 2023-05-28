package com.dimasnoufal.bukucatatanpermateri.API;

import com.dimasnoufal.bukucatatanpermateri.API.model.ResponseCharacter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("character")
    Call<ResponseCharacter> getCharacter();
}