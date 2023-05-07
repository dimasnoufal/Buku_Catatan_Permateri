package com.dimasnoufal.bukucatatanpermateri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dimasnoufal.bukucatatanpermateri.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    // Inisiasi varible
//    EditText etEmail, etPassword;
//    Button btnLogin, btnRegister;
//    TextView tvLupaPassword;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Mengambil id komponen dari layout login
//        etEmail = findViewById(R.id.et_email_login);
//        etPassword = findViewById(R.id.et_password_login);
//        btnLogin = findViewById(R.id.btn_login);
//        btnRegister = findViewById(R.id.btn_register);
//        tvLupaPassword = findViewById(R.id.tv_lupa);

        // Membuat button login bisa diklik

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Mengambil string/inputan text dari edittext
                String email = binding.etEmailLogin.getText().toString().trim();
                String password = binding.etPasswordLogin.getText().toString().trim();

                // Mengvalidasi inputan
                if (TextUtils.isEmpty(email)) {
                    binding.etEmailLogin.setError("Email harus di isi");
                } else if (TextUtils.isEmpty(password)) {
                    binding.etPasswordLogin.setError("Email harus di isi");
                } else {
                    // Mengirim data dan pindah ke activity lain
                    Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                    login.putExtra("email", email);
                    login.putExtra("password", password);
                    startActivity(login);
                }
            }
        });

        binding.tvLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Fitur ini masih belum ada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}