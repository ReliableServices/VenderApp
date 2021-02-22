package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;
import com.reliableservices.venderapp.R;

public class DiscountCoupanActivity extends AppCompatActivity {
    private Toolbar toolbar_layout;
    private TextInputLayout max_discount,dis_amount,percent;
    private RadioGroup percent_flatdis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_coupan);

        start();
        process();
    }

    private void start() {
        toolbar_layout = findViewById(R.id.toolbar_layout);
        max_discount = findViewById(R.id.max_discount);
        dis_amount = findViewById(R.id.dis_amount);
        percent_flatdis = findViewById(R.id.percent_flatdis);
        percent = findViewById(R.id.percent);
    }

    private void process() {
        toolbar_layout.setTitle("Discount Coupan");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        percent_flatdis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                // Add logic here
                switch (index) {
                    case 0: // first button
                        max_discount.setVisibility(View.VISIBLE);
                        percent.setVisibility(View.VISIBLE);
                        dis_amount.setVisibility(View.GONE);
                        break;
                    case 1: // secondbutton
                        max_discount.setVisibility(View.GONE);
                        dis_amount.setVisibility(View.VISIBLE);
                        percent.setVisibility(View.GONE);
                        break;
                }
            }
        });
    }
}