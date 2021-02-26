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
import com.reliableservices.venderapp.adpters.PurchaseListAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class PurchaseOrderListActivity extends AppCompatActivity {
     private RecyclerView purchase_order_list;
     private PurchaseListAdapter purchaseListAdapter;
     private Toolbar toolbar_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_order_list);
        init();
        process();
    }

    private void init() {
        purchase_order_list = findViewById(R.id.purchase_order_list);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }

    private void process() {
        toolbar_layout.setTitle("Purchase Order List");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        String [] catname =  {"Poco", "samsung", "VIVO Pro", "Oppo", "Moto", "Nokiya", "Xaomi"};
        ArrayList<String> productList = new ArrayList<>();
        Collections.addAll(productList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        purchase_order_list.setLayoutManager(layoutManager);
        purchase_order_list.setItemAnimator(new DefaultItemAnimator());
        ProdListAdapter prodListAdapter = new ProdListAdapter(productList, getApplicationContext());
        purchase_order_list.setAdapter(prodListAdapter);




    }
}