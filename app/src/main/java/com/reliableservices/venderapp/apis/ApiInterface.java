package com.reliableservices.venderapp.apis;


import android.widget.TextView;

import com.reliableservices.venderapp.modelclass.BaseResponse;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;

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

    /*Upload new property add form */
   /* @Multipart
    @POST("forsaleha.php")
    Call<BaseResponse> forsaleha(@Query("api_key") String api_key,
                                @Query("data") String data,
                                @Part("img_size") RequestBody img_size,
                                @Part List<MultipartBody.Part> img_files);
    *//*all property api*//*
   @GET("get_data.php")
   Call<PropertyWrapper> getProperty(@Query("api_key") String api_key,
                                     @Query("broker_id") String broker_id);

    *//*all property api*//*
    @GET("my_purchase.php")
    Call<PropertyWrapper> purProduct(@Query("api_key") String api_key,
                                      @Query("broker_id") String broker_id);
   *//*wallet bals*//*
    @GET("wallet_bals.php")
    Call<WalBalWrapper> wallet_bals(@Query("api_key") String api_key,
                                    @Query("broker_id") String broker_id);
  *//*get my property*//*
    @GET("get_my_data.php")
    Call<PropertyWrapper> getMyData(@Query("api_key") String api_key,
                                    @Query("broker_id") String broker_id);
  *//*remove property*//*
    @GET("prod_delete.php")
    Call<BaseResponse> prod_delete(@Query("api_key") String api_key,
                                      @Query("broker_id") String broker_id,
                                      @Query("product_name_id") String product_name_id);
   *//*seraching Property*//*
    @GET("search.php")
    Call<SearchWrapper> searchProperty(@Query("api_key") String api_key,
                                       @Query("key_word")String key_word);

    *//*recharge history *//*
    @GET("get_recharge_history.php")
    Call<RechCardWrapper> rech_history(@Query("api_key") String api_key,
                                       @Query("broker_id")String broker_id);
   *//*get recharge Plan  *//*
    @GET("recharge_master.php")
    Call<RechCardWrapper> recharge_plan(@Query("api_key") String api_key);
    *//*purchase_product api *//*

   *//*registeration Process otp*//*
    @GET("otp_send.php")
    Call<BaseResponse> sendSMS(@Query("api_key") String api_key,
                               @Query("mobile") String mobile,
                               @Query("otp") String otp);
    *//*Login Process otp *//*
    @GET("loginwithotp.php")
    Call<LoginDetailWrapper> loginwithotp(@Query("api_key") String api_key,
                                          @Query("mobile") String mobile,
                                          @Query("otp") String otp,
                                          @Query("device_id")String device_id);

*//*get category table data*//*
    @GET("get_cat_data.php")
    Call<CatWrapper> get_catData(@Query("api_key") String api_key);

    *//*broker account updatation *//*
    @GET("bro_account_update.php")
    Call<AccDetailWrapper> broAccData(@Query("api_key") String api_key,
                                      @Query("data") String data,
//                                      @Part MultipartBody.Part file,
                                      @Query("broker_id") String broker_id);
*//*get Broker detail *//*
    @GET("bro_account_update.php")
    Call<AccDetailWrapper> brokDetail(@Query("api_key") String api_key,
                                      @Query("broker_id") String broker_id);

   // lead open call
    @GET("lead_open_log.php")
    Call<BaseResponse> leadOpen(@Query("api_key") String api_key,
                                     @Query("data") String data);
    // lead open call
    @Multipart
    @POST("profileImage.php")
    Call<AccDetailWrapper> profileImag(@Query("api_key") String api_key,
                                       @Part MultipartBody.Part file,
                                       @Query("mobile") String mobile);

    // @Part MultipartBody.Part file,
    @GET("removelogin.php")
    Call<BaseResponse> removeLogin(@Query("api_key") String api_key,
                                       @Query("mobile") String mobile);
*/
}
