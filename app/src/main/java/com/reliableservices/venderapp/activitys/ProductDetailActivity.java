package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class ProductDetailActivity extends AppCompatActivity {
      private TextView variant_btn;
      private Toolbar toolbar_layout;
      private ImageView add_category,add_comp_name;
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
        add_category = findViewById(R.id.add_category);
        add_comp_name = findViewById(R.id.add_comp_name);
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

        add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this,CreateCategoryActivity.class);
                startActivity(i);
            }
        });

        variant_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this,AddVariants.class);
                startActivity(i);
            }
        });

        add_comp_name .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetailActivity.this);
                View dialogView = LayoutInflater.from(ProductDetailActivity.this).inflate(R.layout.item_company_name, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                TextView clear_btn = dialogView.findViewById(R.id.clear_btn);
                clear_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
                TextView AddCompName = dialogView.findViewById(R.id.add_comp_name);
                AddCompName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
            }
        });

    }
}