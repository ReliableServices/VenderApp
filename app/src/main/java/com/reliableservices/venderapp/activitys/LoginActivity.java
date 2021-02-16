package com.reliableservices.venderapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.reliableservices.venderapp.R;


public class LoginActivity extends AppCompatActivity {
    private TextView Login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        start();
        process();
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,OtpActivity.class);
                startActivity(i);
            }
        });
    }
    private void start() {
        Login_btn = findViewById(R.id.Login_btn);
    }

    private void process() {
    }
}