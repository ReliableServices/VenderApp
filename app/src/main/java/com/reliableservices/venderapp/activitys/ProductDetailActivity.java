package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.common.ShareUtils;
import com.reliableservices.venderapp.modelclass.AddCompModel;
import com.reliableservices.venderapp.modelclass.BusiRegModel;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;
import com.reliableservices.venderapp.modelclass.CityStateData;
import com.reliableservices.venderapp.modelclass.CompNameModel;
import com.reliableservices.venderapp.modelclass.wrapperClass.CityStatePinWrapper;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailActivity extends AppCompatActivity {
      private EditText item_company;
      private TextView variant_btn;
      private Toolbar toolbar_layout;
      private ImageView add_category,add_comp,img_prod;
      private ProgressDialog progressDialog;
      private ShareUtils shareUtils;
    private SpinnerDialog spinnerDialog,spinnerDialog2;
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
        add_comp = findViewById(R.id.add_comp);
        img_prod = findViewById(R.id.img_prod);
        item_company = findViewById(R.id.item_company);
    }
    @SuppressLint("ClickableViewAccessibility")
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

        try {
            getCompany();
        } catch (Exception e) {
            e.printStackTrace();
        }

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



        add_comp.setOnClickListener(new View.OnClickListener() {
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
                AddCompName.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        if (comp_name.getText().toString().equals("")) {
                            comp_name.requestFocus();
                            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Please write company name", MDToast.TYPE_WARNING);
                            mdToast.show();
                        }
                        AddCompModel addCompModel = new AddCompModel();
                        addCompModel.setCompany_id(shareUtils.getStringData(Common.USER_ID));
                        addCompModel.setCmp_name(comp_name.getText().toString());
                        progressDialog.show();
                        Call<BusiRegsWrapper> call = RetrofitCall.getApi().addCompany(new GlobalMethods().Base64Encode(Common.API_KEY),"create",""+new Gson().toJson(addCompModel));
//                        Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&data="+new Gson().toJson(addCompModel));
                        call.enqueue(new Callback<BusiRegsWrapper>() {
                            @Override
                            public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                                if (response.code()==Common.RESPONSE_CODE)
                                {
                                    BusiRegsWrapper busiRegsWrapper= response.body();
                                    if(busiRegsWrapper.getStatus().equals(Common.SUCCESS))
                                    {
                                        alertDialog.cancel();
                                        try {
                                            getCompany();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        Toast.makeText(ProductDetailActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
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

    private void getCompany() {
        Log.d("YYYYYyYYYYY", "getCompany: "+new GlobalMethods().Base64Encode(Common.API_KEY)+"&company_id="+shareUtils.getStringData(Common.USER_ID));
        Call<BusiRegsWrapper> call = RetrofitCall.getApi().getCompany(new GlobalMethods().Base64Encode(Common.API_KEY),shareUtils.getStringData(Common.USER_ID));
        call.enqueue(new Callback<BusiRegsWrapper>() {
            @Override
            public void onResponse(Call<BusiRegsWrapper> call,Response<BusiRegsWrapper> response) {
                BusiRegsWrapper data= response.body();
                if (response.isSuccessful())
                {
                    if(data.getStatus().equals(Common.SUCCESS))
                    {
                        setUpCompany(data.getData());

                    }
                }
            }
            @Override
            public void onFailure(Call<BusiRegsWrapper> call, Throwable throwable) {
                GlobalMethods.fetchErrorMessage(throwable,getApplicationContext());
                Toast.makeText(getApplicationContext(),"Please Connect Internet",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUpCompany(ArrayList<BusiRegModel> data)  {
        item_company.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    spinnerDialog2.showSpinerDialog();
                }
            }
        });

        ArrayList<String> model_name=new ArrayList<>();
        for(BusiRegModel rs: data)
        {
            if (rs.getCompany_name()!=null) {
                model_name.add(rs.getCompany_name());
            }
        }
        spinnerDialog2=new SpinnerDialog(ProductDetailActivity.this,model_name,"Select or Search State",R.style.DialogAnimations_SmileWindow,"Close ");// With 	Animation
        spinnerDialog2.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String item, int position) {

                for (BusiRegModel data:data){
                    if(data.getCompany_name().equals(item)){
                        item_company.setText(item);
//                        String state_id = data.getId();
                    }
                }
            }
        });

    }
}