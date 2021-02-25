package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.reliableservices.venderapp.R;

public class CreateCategoryActivity extends AppCompatActivity {
    private TextView add_category;
    private Toolbar toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        start();
        process();
    }

    private void start(){
        add_category = findViewById(R.id.add_category);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }

    private void process() {
        toolbar_layout.setTitle("Add Category Name");
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
                Toast.makeText(CreateCategoryActivity.this, "Category Sucessfully Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}