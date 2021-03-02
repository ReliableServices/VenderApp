package com.reliableservices.venderapp.apis;


import android.widget.TextView;

import com.reliableservices.venderapp.modelclass.BaseResponse;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;
import com.reliableservices.venderapp.modelclass.wrapperClass.CityStatePinWrapper;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("business_registration.php")
    Call<BusiRegsWrapper> registration(@Query("api_key") String api_key,
                                       @Query("data") String data);

    @GET("login_process.php")
    Call<BusiRegsWrapper> getLogin(@Query("api_key") String api_key,
                                    @Query("mobile") String mobile,
                                    @Query("password") String password);

    // lead open call
    @GET("forgot_otp.php")
    Call<BaseResponse> forgotPassword(@Query("api_key") String api_key,
                                      @Query("mobile") String mobile,
                                      @Query("otp") String otp);

    @GET("update_password.php")
    Call<BaseResponse> updatePassword(@Query("api_key") String api_key,
                                      @Query("password") String password,
                                       @Query("mobile") String mobile);

    @GET("city_state_pincode.php")
    Call<CityStatePinWrapper> getPlace(@Query("api_key") String api_key,
                                       @Query("tag") String tag);

    @GET("item_comp_master.php")
    Call<BusiRegsWrapper> addCompany(@Query("api_key") String api_key,
                                   @Query("tag") String tag,
                                   @Query("password") String password);
}
