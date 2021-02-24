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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.activitys.AddProductActivity;
import com.reliableservices.venderapp.activitys.CreateCategoryActivity;
import com.reliableservices.venderapp.adpters.ProdListAdapter;

import java.util.ArrayList;


public class ProductFragment extends Fragment {
    private TabLayout tabLayout;
    private TextView add_product;
    private Fragment fragment;
    private SearchView searchView;
    private ImageView clear_btn, search_btn;
    private LinearLayout toolbar_layout_2;
    private RelativeLayout toolbar_layout;
//    ProdListAdapter prodListAdapter;


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
       /* ArrayList<String> productList = new ArrayList<>();

        prodListAdapter = new ProdListAdapter(productList, getContext());*/
        start(view);
        process();
        return view;
    }

    private void start(View view) {
        add_product = view.findViewById(R.id.add_product);
        tabLayout = view.findViewById(R.id.tabLayout);
        searchView = view.findViewById(R.id.serch_bar);
        toolbar_layout = view.findViewById(R.id.toolbar_layout);
        toolbar_layout_2 = view.findViewById(R.id.toolbar_layout_2);
        clear_btn = view.findViewById(R.id.clear_btn);
        search_btn = view.findViewById(R.id.search_btn);

    }


    private void process() {
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar_layout_2.setVisibility(View.VISIBLE);
                toolbar_layout.setVisibility(View.GONE);
            }
        });
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar_layout.setVisibility(View.VISIBLE);
                toolbar_layout_2.setVisibility(View.GONE);
            }
        });
        searchView = new SearchView(getContext());
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        loadFragment(new CategoryListFragment());
        add_product.setText("Create New Category");
        add_product.setTag("category");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadFragment(new CategoryListFragment());
                        add_product.setText("Create New Category");
                        add_product.setTag("category");
                        break;
                    case 1:
                        loadFragment(new ProductListFragment());
                        add_product.setText("Add New Product");
                        add_product.setTag("product");
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
                if (add_product.getTag().equals("category")) {
                    Intent i = new Intent(getActivity(), CreateCategoryActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(getActivity(),  AddProductActivity.class);
                    startActivity(i);
                }
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