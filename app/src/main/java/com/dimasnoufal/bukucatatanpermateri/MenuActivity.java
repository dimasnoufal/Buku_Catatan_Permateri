package com.dimasnoufal.bukucatatanpermateri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView tvEmail, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvEmail = findViewById(R.id.tv_email);
        tvPassword = findViewById(R.id.tv_password);

        Intent getData = getIntent();
        String dataEmail = getData.getStringExtra("email");
        String dataPassword = getData.getStringExtra("password");

        tvEmail.setText(dataEmail);
        tvPassword.setText(dataPassword);

    }
}