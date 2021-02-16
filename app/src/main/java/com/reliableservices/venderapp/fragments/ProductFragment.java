package com.reliableservices.venderapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.activitys.AddProductActivity;


public class ProductFragment extends Fragment {
private TextView add_product;
    public ProductFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        start(view);
        process();
        return view;
    }

    private void start(View view) {
        add_product = view.findViewById(R.id.add_product);
    }

    private void process() {
        add_product.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent i = new Intent(getActivity(),AddProductActivity.class);
        startActivity(i);
        }
     });
    }
}