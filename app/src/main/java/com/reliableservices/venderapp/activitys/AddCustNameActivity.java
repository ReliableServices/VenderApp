package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class AddCustNameActivity extends AppCompatActivity {
     private Toolbar toolbar_layout;
     private TextView add_customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customer_name);
       init();
       process();
    }

    private void process() {

        toolbar_layout = findViewById(R.id.toolbar_layout);
        add_customer = findViewById(R.id.add_customer);
    }

    private void init() {
        toolbar_layout.setTitle("Add Customer Details");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
    }
}