package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class AddProductActivity extends AppCompatActivity {
     private TextView continue_btn;
    private Toolbar toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        start();
        process();
    }
    private void start() {
        toolbar_layout = findViewById(R.id.toolbar_layout);
        continue_btn  =findViewById(R.id.continue_btn);
    }
    private void process() {
        toolbar_layout.setTitle("Add Product");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddProductActivity.this,ProductDetailActivity.class);
                startActivity(i);
            }
        });

    }
}