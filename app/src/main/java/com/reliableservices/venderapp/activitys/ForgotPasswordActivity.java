package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.common.GlobalVariable;
import com.reliableservices.venderapp.modelclass.BaseResponse;
import com.valdesekamdem.library.mdtoast.MDToast;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
       private TextView mobile_number_forgot;
       private Button verify_btn;
       private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        start();
        process();
    }

    private void start() {
        progressDialog = new ProgressDialog(this);
        mobile_number_forgot = findViewById(R.id.mobile_number_forgot);
        verify_btn = findViewById(R.id.verify_btn);

    }

    private void process() {
        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mobile_number_forgot.getText().toString().equals(""))
                {
                    mobile_number_forgot.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), " Enter Mobile Number", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }else {
                    Random random = new Random();
                    String generatedPassword = String.format("%04d", random.nextInt(10000));
//                    Toast.makeText(ForgotPasswordActivity.this, "Generated Password :" + generatedPassword, Toast.LENGTH_SHORT).show();
                    /* Log.d("MyApp", "Generated Password : " + generatedPassword);*/
                    try {
                        sendSMS(mobile_number_forgot.getText().toString(),generatedPassword);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    private void sendSMS( String mobile,String otp ) {
        progressDialog.show();
        Call<BaseResponse> call = RetrofitCall.getApi().forgotPassword(new GlobalMethods().Base64Encode(Common.API_KEY),mobile,otp);
        Log.d("YYYYYYY", "sendSMS: "+new GlobalMethods().Base64Encode(Common.API_KEY)+mobile+otp);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.code()==Common.RESPONSE_CODE)
                {
                    BaseResponse loginwithotp= response.body();
                    try {
                        if(loginwithotp.getStatus().equals(Common.SUCCESS))
                        {
                            Intent i = new Intent(ForgotPasswordActivity.this,OtpActivity.class);
                            i.putExtra("otp",otp);
                            i.putExtra("mobile",mobile);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(i);
                            MDToast mdToast = MDToast.makeText(getApplicationContext(),loginwithotp.getMessage(), MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                            mdToast.show();
                        }
                        else
                        {
                            MDToast mdToast = MDToast.makeText(getApplicationContext(),loginwithotp.getMessage(), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
                            mdToast.show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
            @Override
            public void onFailure(Call<BaseResponse> call, Throwable throwable) {
                progressDialog.dismiss();
                GlobalMethods.fetchErrorMessage(throwable,getApplicationContext());
            }
        });
    }
}