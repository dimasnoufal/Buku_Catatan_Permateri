package com.dimasnoufal.bukucatatanpermateri.API;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.dimasnoufal.bukucatatanpermateri.API.model.ResponseCharacter;
import com.dimasnoufal.bukucatatanpermateri.API.model.ResultsItem;
import com.dimasnoufal.bukucatatanpermateri.R;
import com.dimasnoufal.bukucatatanpermateri.databinding.ActivityApiBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiActivity extends AppCompatActivity {

    private ActivityApiBinding binding;

    private ApiAdapter apiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvApi.setHasFixedSize(true);
        binding.rvApi.setLayoutManager(new LinearLayoutManager(this));

        ApiConfig.service.getCharacter().enqueue(new Callback<ResponseCharacter>() {
            @Override
            public void onResponse(Call<ResponseCharacter> call, Response<ResponseCharacter> response) {
                if (response.isSuccessful()) {
                    ResponseCharacter responseCharacter = response.body();
                    List<ResultsItem> result = responseCharacter.getResults();
                    apiAdapter = new ApiAdapter(result);
                    binding.rvApi.setAdapter(apiAdapter);
                } else {
                    Toast.makeText(ApiActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCharacter> call, Throwable t) {
                Toast.makeText(ApiActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}