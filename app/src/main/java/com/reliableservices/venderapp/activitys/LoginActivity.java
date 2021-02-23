package com.reliableservices.venderapp.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.common.ShareUtils;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;
import com.valdesekamdem.library.mdtoast.MDToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private TextView Login_btn,newRegister,password,number,forgot_password;
    private ProgressDialog progressDialog;
    private ShareUtils shareUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        start();
        process();
    }
    private void start() {
        progressDialog = new ProgressDialog(this);
        shareUtils = new ShareUtils(LoginActivity.this);
        Login_btn = findViewById(R.id.Login_btn);
        newRegister  =findViewById(R.id.newRegister);
        password = findViewById(R.id.password);
        number = findViewById(R.id.number);
        forgot_password = findViewById(R.id.forgot_password);
    }
    private void process() {
        if (shareUtils.getStringData(Common.IS_LOGIN).equals("TRUE"))
        {
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }else {

        }

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number.getText().toString().trim().equals("")) {
                    number.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), " Enter Register Mobile Number", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }else if(password.getText().toString().trim().equals("")) {
                    password.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Password ", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                } else{
                    progressDialog.show();
                    Call<BusiRegsWrapper> call = RetrofitCall.getApi().getLogin(new GlobalMethods().Base64Encode(Common.API_KEY),number.getText().toString(),password.getText().toString());
                    Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&mobile="+number+"&password="+password);
                    call.enqueue(new Callback<BusiRegsWrapper>() {
                        @Override
                        public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                            if (response.code()==Common.RESPONSE_CODE)
                            {
                                BusiRegsWrapper busiRegsWrapper= response.body();
                                if(busiRegsWrapper.getStatus().equals(Common.SUCCESS))
                                {
                                    shareUtils.saveString(Common.IS_LOGIN,"TRUE");
                                 /*   shareUtils.saveString(Common.USER_ID,busiRegsWrapper.getData().get(0).getUser_id());
                                    shareUtils.saveString(Common.USER_NAME,loginDataWrapper.getData().get(0).getName());
                                    shareUtils.saveString(Common.PRINT,loginDataWrapper.getData().get(0).getPrint());
                                    shareUtils.saveString(Common.ADDRESS,loginDataWrapper.getData().get(0).getAddress());
                                    shareUtils.saveString(Common.MOBILE,loginDataWrapper.getData().get(0).getMobile());
                                    shareUtils.saveString(Common.CITY,loginDataWrapper.getData().get(0).getCity());
                                    shareUtils.saveString(Common.STATE,loginDataWrapper.getData().get(0).getState());
                                    shareUtils.saveString(Common.PIN_CODE,loginDataWrapper.getData().get(0).getPin_code());
                                    shareUtils.saveString(Common.EMAIL,loginDataWrapper.getData().get(0).getEmail());
                                    shareUtils.saveString(Common.PHOTO,loginDataWrapper.getData().get(0).getPhoto());
                                    shareUtils.saveString(Common.GEO_LOCATION,loginDataWrapper.getData().get(0).getGeo_location());*/
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                }else
                                {
                                    Toast.makeText(LoginActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
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
            }
        });
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, VenderRegistrationActivity.class);
                startActivity(i);
            }
        });
    }
}