package com.reliableservices.venderapp.fragments;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.activitys.AddProductActivity;


public class ProductFragment extends Fragment {
    private TabLayout tabLayout;
    private TextView add_product;
    private Fragment fragment;
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
        tabLayout = view.findViewById(R.id.tabLayout);
    }



    private void process() {


        loadFragment(new ProductListFragment());
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        loadFragment(new ProductListFragment());
                        break;
                    case 1:
                        loadFragment(new CategoryListFragment());
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        add_product.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent i = new Intent(getActivity(),AddProductActivity.class);
        startActivity(i);
        }
     });

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}