package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class AddProductActivity extends AppCompatActivity {
     private TextView continue_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        start();
        process();

    }

    private void start() {
        continue_btn  =findViewById(R.id.continue_btn);
    }

    private void process() {
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddProductActivity.this,ProductDetailActivity.class);
                startActivity(i);
            }
        });

    }
}