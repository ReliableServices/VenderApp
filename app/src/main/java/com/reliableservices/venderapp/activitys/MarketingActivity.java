package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.reliableservices.venderapp.R;

public class MarketingActivity extends AppCompatActivity {
    private Toolbar toolbar_layout;
    private RelativeLayout whatsp_stories_relative,promo_card_relative,bussiness_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);
        start();
        process();
    }

    private void start() {
        whatsp_stories_relative = findViewById(R.id.whatsp_stories_relative);
        promo_card_relative = findViewById(R.id.promo_card_relative);
        bussiness_card = findViewById(R.id.bussiness_card);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }

    private void process() {

        toolbar_layout.setTitle("Marketing Tools");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        whatsp_stories_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketingActivity.this,WhatspStoriesActivity.class);
                startActivity(i);
            }
        });

        promo_card_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MarketingActivity.this,PromoCardActivity.class);
                startActivity(i);
            }
        });
        bussiness_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MarketingActivity.this,BusinessCardActivity.class);
                startActivity(i);
            }
        });
    }
}