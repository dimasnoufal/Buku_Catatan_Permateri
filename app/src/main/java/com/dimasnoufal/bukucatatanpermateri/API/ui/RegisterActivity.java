package com.dimasnoufal.bukucatatanpermateri.API.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.dimasnoufal.bukucatatanpermateri.API.ApiConfig;
import com.dimasnoufal.bukucatatanpermateri.API.model.register.ResponseRegister;
import com.dimasnoufal.bukucatatanpermateri.R;
import com.dimasnoufal.bukucatatanpermateri.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = binding.etName.getText().toString().trim();
                String getEmail = binding.etEmail.getText().toString().trim();
                String getPassword = binding.etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(getName)) {
                    binding.etName.setError("Nama Tidak Boleh Kosong");
                } else if (TextUtils.isEmpty(getEmail)) {
                    binding.etEmail.setError("Email Tidak Boleh Kosong");
                } else if (TextUtils.isEmpty(getPassword)) {
                    binding.etPassword.setError("Password Tidak Boleh Kosong");
                } else {
                    register(getName, getEmail, getPassword);
                }
            }
        });


    }

    private void register(String getName, String getEmail, String getPassword) {
        ApiConfig.service.requestRegister(getName, getEmail, getPassword).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()) {
                    ResponseRegister responseRegister = response.body();
                    boolean status = responseRegister.isError();
                    if (!status) {
                        Toast.makeText(RegisterActivity.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(login);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register Gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Response Gagal", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
            }
        });
    }
}