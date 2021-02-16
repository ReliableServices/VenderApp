package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class ProductDetailActivity extends AppCompatActivity {
      private TextView variant_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        start();
        process();
    }

    private void start() {
        variant_btn = findViewById(R.id.variant_btn);
    }
    private void process() {
        variant_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this,AddVariants.class);
                startActivity(i);
            }
        });

    }
}