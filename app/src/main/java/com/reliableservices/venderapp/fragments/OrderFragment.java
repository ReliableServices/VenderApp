package com.reliableservices.venderapp.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.activitys.AddOrderActivity;
import com.reliableservices.venderapp.adpters.OrderAllAdapter;

import java.util.ArrayList;
import java.util.Collections;

import static com.reliableservices.venderapp.R.drawable.background_lite_gray_roundshape;
import static com.reliableservices.venderapp.R.drawable.btn_status_background;

public class OrderFragment extends Fragment {
    private TextView last_month,this_month,this_week,yesterday,today,alltime,txt_add_order;
    private RecyclerView recy_order_all;
    private OrderAllAdapter orderAllAdapter;
    private Toolbar toolbar;
    private RelativeLayout empty_relative;
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
        recy_order_all = view.findViewById(R.id.recy_order_all);
        alltime = view.findViewById(R.id.alltime);
        today = view.findViewById(R.id.today);
        yesterday = view.findViewById(R.id.yesterday);
        this_week = view.findViewById(R.id.this_week);
        this_month = view.findViewById(R.id.this_month);
        last_month = view.findViewById(R.id.last_month);
        txt_add_order = view.findViewById(R.id.txt_add_order);
        empty_relative = view.findViewById(R.id.empty_relative);
    }

    //horizontal scrolling button
    private void process() {
        txt_add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AddOrderActivity.class);
                startActivity(i);
            }
        });
        String [] catname =  {"Poco", "samsung", "VIVO Pro", "Oppo", "Moto", "Nokiya", "Xaomi"};
        ArrayList<String> orederList = new ArrayList<>();
        Collections.addAll(orederList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recy_order_all.setLayoutManager(layoutManager);
        recy_order_all.setItemAnimator(new DefaultItemAnimator());
        OrderAllAdapter orderAllAdapter = new OrderAllAdapter(orederList, getContext());
        recy_order_all.setAdapter(orderAllAdapter);

        alltime.setBackgroundResource(btn_status_background);
        alltime.setTextColor(getResources().getColor(R.color.white));

        alltime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(alltime);
                recy_order_all.setVisibility(View.VISIBLE);
                empty_relative.setVisibility(View.GONE);
            }
        });
        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(today);
                recy_order_all.setVisibility(View.GONE);
                empty_relative.setVisibility(View.VISIBLE);
            }
        });
        yesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(yesterday);
                recy_order_all.setVisibility(View.VISIBLE);
                empty_relative.setVisibility(View.GONE);
            }
        });
        this_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(this_week);
                recy_order_all.setVisibility(View.GONE);
                empty_relative.setVisibility(View.VISIBLE);
            }
        });
        this_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(this_month);
                recy_order_all.setVisibility(View.VISIBLE);
                empty_relative.setVisibility(View.GONE);
            }
        });
        last_month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBg(last_month);
                recy_order_all.setVisibility(View.GONE);
                empty_relative.setVisibility(View.VISIBLE);
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

    //scrolling exit

}