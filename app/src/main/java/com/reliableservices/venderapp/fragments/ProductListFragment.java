package com.reliableservices.venderapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.adpters.OrderAllAdapter;
import com.reliableservices.venderapp.adpters.ProdListAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class ProductListFragment extends Fragment {
    private RecyclerView recy_prod_list;
    public ProductListFragment() {
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

         View view =  inflater.inflate(R.layout.fragment_product_list, container, false);
         start(view);
         process();
         return view;

    }

    private void start(View view) {
        recy_prod_list = view.findViewById(R.id.recy_prod_list);
    }
    private void process() {
        String [] catname =  {"Poco", "samsung", "VIVO Pro", "Oppo", "Moto", "Nokiya", "Xaomi"};
        ArrayList<String> productList = new ArrayList<>();
        Collections.addAll(productList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recy_prod_list.setLayoutManager(layoutManager);
        recy_prod_list.setItemAnimator(new DefaultItemAnimator());
        ProdListAdapter prodListAdapter = new ProdListAdapter(productList, getContext());
        recy_prod_list.setAdapter(prodListAdapter);

    }
}