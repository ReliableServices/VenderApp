package com.reliableservices.venderapp.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.modelclass.BusiRegModel;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;
import com.valdesekamdem.library.mdtoast.MDToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenderRegistrationActivity extends AppCompatActivity {
    private Toolbar toolbar_layout;
    private EditText bussiness_name,mobile_nume,full_Address,contact_person_name,email_id,state_name,city,pincode;
    private TextView finish_btn;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_registration);
        start();
        process();
    }

    private void start() {
        progressDialog = new ProgressDialog(this);
        toolbar_layout = findViewById(R.id.toolbar_layout);
        finish_btn = findViewById(R.id.finish_btn);
        full_Address = findViewById(R.id.full_Address);
        bussiness_name  =findViewById(R.id.bussiness_name);
        mobile_nume = findViewById(R.id.mobile_nume);
        contact_person_name = findViewById(R.id.contact_person_name);
        email_id = findViewById(R.id.email_id);
        state_name = findViewById(R.id.state_name);
        city= findViewById(R.id.city);
        pincode= findViewById(R.id.pincode);
    }

    private void process() {
        toolbar_layout.setTitle("New Vender Registration");
        setSupportActionBar(toolbar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar_layout.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar_layout.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       finish_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               BusiRegistration();
           }
       });


    }

    private void BusiRegistration() {
        if (bussiness_name.getText().toString().trim().equals("")) {
            bussiness_name.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Please Enter Full Name", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        } else if (contact_person_name.getText().toString().trim().equals("")) {
            contact_person_name.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Email Id", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        } else if (!isValidEmail(email_id.getText().toString().trim())){
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Valid Email Id", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }else if (mobile_nume.getText().toString().trim().equals("")) {
            mobile_nume.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Valid Number", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        } else if (mobile_nume.getText().length() != 10) {
            mobile_nume.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter valid 10 digit  Number", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }else if (full_Address.getText().toString().trim().equals("")) {
            full_Address.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Country Name Id", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }else if (state_name.getText().toString().trim().equals("")) {
            state_name.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter State Name ", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }else if (city.getText().toString().trim().equals("")) {
            city.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter City Name", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        } else if (pincode.getText().toString().trim().equals("")) {
            pincode.requestFocus();
            MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Pincode ", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
            mdToast.show();
        }else {
            BusiRegModel busiRegModel = new BusiRegModel();
            busiRegModel.setCompany_name(bussiness_name.getText().toString());
            busiRegModel.setMobile(mobile_nume.getText().toString());
            busiRegModel.setPerson_name(contact_person_name.getText().toString());
            busiRegModel.setEmail(email_id.getText().toString());
            busiRegModel.setAddress(full_Address.getText().toString());
            busiRegModel.setState(state_name.getText().toString());
            busiRegModel.setCity(city.getText().toString());
            busiRegModel.setPin_code(pincode.getText().toString());
            progressDialog.show();
            Call<BusiRegsWrapper> call = RetrofitCall.getApi().registration(new GlobalMethods().Base64Encode(Common.API_KEY),""+new Gson().toJson(busiRegModel));
//            Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&data="+new Gson().toJson(busiRegModel));
            call.enqueue(new Callback<BusiRegsWrapper>() {
                @Override
                public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                    BusiRegsWrapper data= response.body();
                    if (response.isSuccessful())
                    {
                        if(data.getStatus().equals(Common.SUCCESS))
                        {
                            Intent intent = new Intent(VenderRegistrationActivity.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        Toast.makeText(getApplicationContext(), data.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    progressDialog.dismiss();
                }
                @Override
                public void onFailure(Call<BusiRegsWrapper> call, Throwable throwable) {
                    progressDialog.dismiss();
                    Toast.makeText(VenderRegistrationActivity.this, ""+throwable.toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private static boolean isValidEmail(String email_id) {
        return !TextUtils.isEmpty(email_id) && android.util.Patterns.EMAIL_ADDRESS.matcher(email_id).matches();
    }
}