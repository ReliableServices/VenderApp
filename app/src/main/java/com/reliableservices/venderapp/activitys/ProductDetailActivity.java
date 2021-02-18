package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class ProductDetailActivity extends AppCompatActivity {
      private TextView variant_btn;
      private Toolbar toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        start();
        process();
    }

    private void start() {
        variant_btn = findViewById(R.id.variant_btn);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }
    private void process() {
        toolbar_layout.setTitle("Product Details");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        variant_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this,AddVariants.class);
                startActivity(i);
            }
        });

    }
}