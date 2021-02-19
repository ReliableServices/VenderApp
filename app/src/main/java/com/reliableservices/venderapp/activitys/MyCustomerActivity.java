package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.adpters.MyCustAdapter;
import com.reliableservices.venderapp.adpters.ProdListAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MyCustomerActivity extends AppCompatActivity {
      private RecyclerView recycler_cust_list;
      private Toolbar toolbar_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_customer);
        start();
        process();
    }

    private void start() {
        recycler_cust_list = findViewById(R.id.recycler_cust_list);
        toolbar_layout = findViewById(R.id.toolbar_layout);
    }

    private void process() {

        toolbar_layout.setTitle("My Customer");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        String [] catname =  {"Aman", "Homendra", "Santu", "Rishi", "Rahul", "Roshan", "Rohit"};
        ArrayList<String> productList = new ArrayList<>();
        Collections.addAll(productList, catname);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recycler_cust_list.setLayoutManager(layoutManager);
        recycler_cust_list.setItemAnimator(new DefaultItemAnimator());
        MyCustAdapter myCustAdapter = new MyCustAdapter(productList, getApplicationContext());
        recycler_cust_list.setAdapter(myCustAdapter);

    }
}