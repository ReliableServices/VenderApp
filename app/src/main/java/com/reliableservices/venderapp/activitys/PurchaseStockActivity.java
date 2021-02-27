package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

public class PurchaseStockActivity extends AppCompatActivity {
    private Toolbar toolbar_layout;
    private ImageView add_supplier,Add_item,add_comp_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_stock);
        init();
        process();
    }

    private void init() {
        toolbar_layout = findViewById(R.id.toolbar_layout);
        add_supplier = findViewById(R.id.add_supplier);
        Add_item = findViewById(R.id.Add_item);
        add_comp_name = findViewById(R.id.add_comp_name);
    }
    private void process() {
        toolbar_layout.setTitle("Add Purchase Order ");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_comp_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PurchaseStockActivity.this);
                View dialogView = LayoutInflater.from(PurchaseStockActivity.this).inflate(R.layout.item_company_name, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                TextView clear_btn = dialogView.findViewById(R.id.clear_btn);
                clear_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
                TextView AddCompName = dialogView.findViewById(R.id.add_comp_name);
                AddCompName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
            }
        });
        Add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PurchaseStockActivity.this,AddProductActivity.class);
                startActivity(i);
            }
        });

        add_supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PurchaseStockActivity.this,AddCustNameActivity.class);
                startActivity(i);
            }
        });
    }
}