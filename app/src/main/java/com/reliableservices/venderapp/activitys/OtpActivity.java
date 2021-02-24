package com.reliableservices.venderapp.activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.modelclass.BaseResponse;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;
import com.valdesekamdem.library.mdtoast.MDToast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {
    private Button verify_btn;
    private TextView otp_txt,new_password,confirm_password;
    private ProgressDialog progressDialog;
    private String otp ,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        start();
        process();
    }

    private void start() {
        progressDialog = new ProgressDialog(this);
        verify_btn = findViewById(R.id.verify_btn);
        otp_txt = findViewById(R.id.otp);
        new_password =findViewById(R.id.new_password);
        confirm_password = findViewById(R.id.confirm_password);
    }
    private void process() {
        otp = getIntent().getStringExtra("otp");
        mobile = getIntent().getStringExtra("mobile");
        verify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otp_txt.getText().toString().trim().equals("otp")) {
                    otp_txt.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), " Enter OTP", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }else if(new_password.getText().toString().trim().equals("")) {
                    new_password.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), " Enter Register Mobile Number", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }else if(confirm_password.getText().toString().trim().equals("")) {
                    confirm_password.requestFocus();
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), "Enter Password ", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                }else if(confirm_password.getText().toString().trim().equals(new_password)) {
                    MDToast mdToast = MDToast.makeText(getApplicationContext(), "password does not match, please enter same password ", MDToast.LENGTH_SHORT, MDToast.TYPE_WARNING);
                    mdToast.show();
                } else
                {
                    progressDialog.show();
                    Call<BaseResponse> call = RetrofitCall.getApi().updatePassword(new GlobalMethods().Base64Encode(Common.API_KEY),confirm_password.getText().toString(),mobile);
//                    Log.d("AAAAAAAAAA", "?api_key="+new GlobalMethods().Base64Encode(Common.API_KEY)+"&mobile="+number+"&password="+password+"&");
                    call.enqueue(new Callback<BaseResponse>() {
                        @Override
                        public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                            if (response.code()==Common.RESPONSE_CODE)
                            {
                                BaseResponse busiRegsWrapper= response.body();
                                if(busiRegsWrapper.getStatus().equals(Common.SUCCESS))
                                {
                                 /* shareUtils.saveString(Common.USER_ID,busiRegsWrapper.getData().get(0).getUser_id());
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
                                    Intent i = new Intent(OtpActivity.this, LoginActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                    Toast.makeText(OtpActivity.this,busiRegsWrapper.getMessage(),Toast.LENGTH_SHORT).show();
                                    startActivity(i);
                                }else
                                {
                                    Toast.makeText(OtpActivity.this,busiRegsWrapper.getMessage() , Toast.LENGTH_SHORT).show();
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
        });
    }
}