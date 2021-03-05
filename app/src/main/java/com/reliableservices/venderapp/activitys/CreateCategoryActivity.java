package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
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

public class CreateCategoryActivity extends AppCompatActivity {
    private EditText cat_name,cgst,sgst,igst,ogst,osgst,oigst,hsn_code;
    private TextView add_category_btn;
    private Toolbar toolbar_layout;
    private ShareUtils shareUtils;
    private ProgressDialog progressDialog;
    private AlertDialog alertDialog;
    private  int gstCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_category);
        start();
        process();
    }

    private void start(){
        shareUtils = new ShareUtils(this);
        progressDialog = new ProgressDialog(this);
        add_category_btn = findViewById(R.id.add_category);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        cat_name = findViewById(R.id.cat_name);
        hsn_code = findViewById(R.id.selling_p);
        cgst = findViewById(R.id.cgst);
        sgst = findViewById(R.id.sgst);
        igst = findViewById(R.id.igst);
        ogst = findViewById(R.id.ogst);
        osgst = findViewById(R.id.osgst);
        oigst = findViewById(R.id.oigst);
    }

    private void process() {
        toolbar_layout.setTitle("Add Category Name");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        gstCount = Integer.parseInt(cgst.getText().toString());
        sgst.setText(String.valueOf(gstCount));
        igst.setText(String.valueOf(gstCount*2));
        ogst.setText(String.valueOf(gstCount));
        osgst.setText(String.valueOf(gstCount));
        oigst.setText(String.valueOf(gstCount*2));


        add_category_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCompModel addCatModel = new AddCompModel();
                addCatModel.setCategory_name(cat_name.getText().toString());
                addCatModel.setCompany_id(shareUtils.getStringData(Common.USER_ID));
                addCatModel.setIcgst(String.valueOf(gstCount));
                addCatModel.setIigst(String.valueOf(gstCount));
                addCatModel.setIsgst(String.valueOf(gstCount*2));

                progressDialog.show();
                Call<BusiRegsWrapper> call = RetrofitCall.getApi().addCategory(new GlobalMethods().Base64Encode(Common.API_KEY),"create",""+new Gson().toJson(addCatModel));
                Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&tag="+"create"+"&data="+new Gson().toJson(addCatModel));
                call.enqueue(new Callback<BusiRegsWrapper>() {
                    @Override
                    public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                        if (response.code()==Common.RESPONSE_CODE)
                        {
                            BusiRegsWrapper busiRegsWrapper= response.body();
                            if(busiRegsWrapper.getStatus().equals(Common.SUCCESS))
                            {
                                Toast.makeText(CreateCategoryActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
                            }else
                            {
                                Toast.makeText(CreateCategoryActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
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
}