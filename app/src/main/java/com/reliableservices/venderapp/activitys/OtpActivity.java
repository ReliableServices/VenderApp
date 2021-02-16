package com.reliableservices.venderapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.reliableservices.venderapp.R;

public class OtpActivity extends AppCompatActivity {
    private Button verify_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        start();
        process();
    }

    private void start() {
        verify_btn = findViewById(R.id.verify_btn);
    }

    private void process() {
        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtpActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}