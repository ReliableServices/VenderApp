package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class AddOrderActivity extends AppCompatActivity {
   private EditText customer_name,item_name,mrp,sell_price,qty,house_num,land_mark,area,state,pincode,distric;
   private TextView add_order;
   private Toolbar toolbar_layout;
   private ImageView add_cust_name,add_bom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        start();
        process();
    }
    private void start() {
        customer_name = findViewById(R.id.customer_name);
        item_name = findViewById(R.id.item_name);
        mrp = findViewById(R.id.mrp);
        sell_price = findViewById(R.id.sell_price);
        house_num = findViewById(R.id.house_num);
        area = findViewById(R.id.area);
        state = findViewById(R.id.state_name);
        pincode = findViewById(R.id.pincode);
        add_order = findViewById(R.id.add_order);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        add_bom = findViewById(R.id.add_bom);
        add_cust_name = findViewById(R.id.add_cust_name);

    }
    private void process() {
        toolbar_layout.setTitle(" Order Entry ");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        });
        add_cust_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddOrderActivity.this, AddCustNameActivity.class);
                startActivity(i);
            }
        });
        add_bom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddOrderActivity.this,AddProductActivity.class);
                startActivity(i);
            }
        });

    }
}