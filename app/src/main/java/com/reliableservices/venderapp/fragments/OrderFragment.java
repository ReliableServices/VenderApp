package com.reliableservices.venderapp.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.reliableservices.venderapp.R;

import static com.reliableservices.venderapp.R.drawable.background_lite_gray_roundshape;
import static com.reliableservices.venderapp.R.drawable.btn_status_background;

public class OrderFragment extends Fragment {
    private TextView last_month,this_month,this_week,yesterday,today,alltime;
    private Toolbar toolbar;
    public OrderFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_order, container, false);
        start(view);
        process();
        return view;
    }
    private void start(View view) {
        alltime = view.findViewById(R.id.alltime);
        today = view.findViewById(R.id.today);
        yesterday = view.findViewById(R.id.yesterday);
        this_week = view.findViewById(R.id.this_week);
        this_month = view.findViewById(R.id.this_month);
        last_month = view.findViewById(R.id.last_month);
    }
    private void process() {
        alltime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(alltime);
            }
        });
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(today);
            }
        });
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(yesterday);
            }
        });
        this_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(this_week);
            }
        });
        this_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(this_month);
            }
        });
        last_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(last_month);
            }
        });
    }
    private void changeBg(TextView textview)
    {
        last_month.setBackgroundResource(background_lite_gray_roundshape);
        last_month.setTextColor(getResources().getColor(R.color.black));
        this_month.setBackgroundResource(background_lite_gray_roundshape);
        this_month.setTextColor(getResources().getColor(R.color.black));
        this_week.setBackgroundResource(background_lite_gray_roundshape);
        this_week.setTextColor(getResources().getColor(R.color.black));
        today.setBackgroundResource(background_lite_gray_roundshape);
        today.setTextColor(getResources().getColor(R.color.black));
        yesterday.setBackgroundResource(background_lite_gray_roundshape);
        yesterday.setTextColor(getResources().getColor(R.color.black));
        alltime.setBackgroundResource(background_lite_gray_roundshape);
        alltime.setTextColor(getResources().getColor(R.color.black));
        textview.setTextColor(getResources().getColor(R.color.white));
        textview.setBackgroundResource(btn_status_background);
    }

}