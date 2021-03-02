package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.common.ShareUtils;
import com.reliableservices.venderapp.modelclass.AddCompModel;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {
      private TextView variant_btn;
      private Toolbar toolbar_layout;
      private ImageView add_category,add_comp_name,img_prod;
      private ProgressDialog progressDialog;
      private ShareUtils shareUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        start();
        process();
    }

    private void start() {
        progressDialog = new ProgressDialog(this);
        shareUtils = new ShareUtils(this);
        variant_btn = findViewById(R.id.variant_btn);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        add_category = findViewById(R.id.add_category);
        add_comp_name = findViewById(R.id.add_comp_name);
        img_prod = findViewById(R.id.img_prod);
    }
    private void process() {
        toolbar_layout.setTitle("Product Details");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this,CreateCategoryActivity.class);
                startActivity(i);
            }
        });

        variant_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProductDetailActivity.this, AddVariantsActivity.class);
                startActivity(i);
            }
        });

        img_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        add_comp_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetailActivity.this);
                View dialogView = LayoutInflater.from(ProductDetailActivity.this).inflate(R.layout.item_company_name, null);
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
                EditText comp_name = dialogView.findViewById(R.id.comp_name);
                AddCompModel addCompModel = new AddCompModel();
                addCompModel.setCmp_name(comp_name.getText().toString());
               addCompModel.getCompany_id(shareUtils.);


                AddCompName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressDialog.show();
                        Call<BusiRegsWrapper> call = RetrofitCall.getApi().addCompany(new GlobalMethods().Base64Encode(Common.API_KEY),"ceate",,company_id);
                        Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&mobile="+number+"&password="+password);
                        call.enqueue(new Callback<BusiRegsWrapper>() {
                            @Override
                            public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                                if (response.code()==Common.RESPONSE_CODE)
                                {
                                    BusiRegsWrapper busiRegsWrapper= response.body();
                                    if(busiRegsWrapper.getStatus().equals(Common.SUCCESS))
                                    {

                                    }else
                                    {
                                        Toast.makeText(ProductDetailActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
                                    }
                                }
                                progressDialog.dismiss();
                            }
                            @Override
                            public void onFailure(Call<BusiRegsWrapper> call, Throwable throwable) {
                                progressDialog.dismiss();
                                GlobalMethods.fetchErrorMessage(throwable,getApplicationContext());
                            }
                        });
                    }
                });
            }
        });

    }
}