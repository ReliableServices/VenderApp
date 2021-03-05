package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.adpters.ProdListAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class ProductListActivity extends AppCompatActivity {
    private RecyclerView prod_list_Rcy;
    private Toolbar toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list2);
        init();
        process();
    }


    private void init() {
        prod_list_Rcy = findViewById(R.id.prod_list_Rcy);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }

    private void process() {
        toolbar_layout.setTitle(" Product List");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
        String catname  [] = { "h","j","k"};
        ArrayList<String> productList = new ArrayList<>();
        Collections.addAll(productList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        prod_list_Rcy.setLayoutManager(layoutManager);
        prod_list_Rcy.setItemAnimator(new DefaultItemAnimator());
        ProdListAdapter prodListAdapter = new ProdListAdapter(productList, getApplicationContext());
        prod_list_Rcy.setAdapter(prodListAdapter);

    }

}