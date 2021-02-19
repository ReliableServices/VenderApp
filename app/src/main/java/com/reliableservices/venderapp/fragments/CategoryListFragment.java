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
import com.reliableservices.venderapp.adpters.CategoryAdapter;
import com.reliableservices.venderapp.adpters.ProdListAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class CategoryListFragment extends Fragment {
      private RecyclerView recy_category_list;
      private CategoryAdapter catAdapter;
    public CategoryListFragment() {
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
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
         init(view);
        process();
        return view;
    }

    private void init( View view) {
        recy_category_list = view.findViewById(R.id.recy_category_list);
    }

    private void process() {
        String [] catname =  {"Fashion", "Mobiles", "Electronics", "Home", "Beauty", "Furniture", "Grocery"};
        ArrayList<String> productList = new ArrayList<>();
        Collections.addAll(productList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recy_category_list.setLayoutManager(layoutManager);
        recy_category_list.setItemAnimator(new DefaultItemAnimator());
        CategoryAdapter prodListAdapter = new CategoryAdapter(productList, getContext());
        recy_category_list.setAdapter(prodListAdapter);



    }
}