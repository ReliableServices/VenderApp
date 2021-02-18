package com.reliableservices.venderapp.fragments;

import android.content.Intent;
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
import com.reliableservices.venderapp.activitys.DiscountCoupanActivity;
import com.reliableservices.venderapp.activitys.ExtraChargeActivity;


public class ManageFragment extends Fragment {
    private Toolbar toolbar;
    private TextView extra_charges,wtsp_chat_support,marketing_design,discount_coupan,my_customers,store_qr_code;

    public ManageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_manage, container, false);
        start(view);
        process();
        return view;
    }

    private void start( View view)
    {
     toolbar = view.findViewById(R.id.toolbar);
        extra_charges = view.findViewById(R.id.extra_charges);
        wtsp_chat_support = view.findViewById(R.id.wtsp_chat_support);
        marketing_design = view.findViewById(R.id.marketing_design);
        discount_coupan = view.findViewById(R.id.discount_coupan);
        my_customers = view.findViewById(R.id.my_customers);
        store_qr_code = view.findViewById(R.id.store_qr_code);
    }

    private void process() {
        extra_charges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),ExtraChargeActivity.class);
                startActivity(i);
            }
        });

        discount_coupan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),DiscountCoupanActivity.class);
                startActivity(i);
            }
        });
    }
}