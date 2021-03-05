package com.reliableservices.venderapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.adpters.CategoryAdapter;
import com.reliableservices.venderapp.adpters.ProdListAdapter;
import com.reliableservices.venderapp.apis.RetrofitCall;
import com.reliableservices.venderapp.common.Common;
import com.reliableservices.venderapp.common.GlobalMethods;
import com.reliableservices.venderapp.common.ShareUtils;
import com.reliableservices.venderapp.modelclass.BusiRegModel;
import com.reliableservices.venderapp.modelclass.BusiRegsWrapper;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryListFragment extends Fragment {
      private RecyclerView recy_category_list;
      private CategoryAdapter catAdapter;
      private ShareUtils shareUtils;
    public CategoryListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
         init(view);
        process();
        return view;
    }

    private void init( View view) {
        shareUtils = new ShareUtils(getActivity());
        recy_category_list = view.findViewById(R.id.recy_category_list);
    }

    private void process() {


        try {
            Log.d("YYYYYyYYYYY", "getCompany: "+new GlobalMethods().Base64Encode(Common.API_KEY)+"&company_id="+shareUtils.getStringData(Common.USER_ID));
            Call<BusiRegsWrapper> call = RetrofitCall.getApi().getCategory(new GlobalMethods().Base64Encode(Common.API_KEY),shareUtils.getStringData(Common.USER_ID));
            call.enqueue(new Callback<BusiRegsWrapper>() {
                @Override
                public void onResponse(Call<BusiRegsWrapper> call, Response<BusiRegsWrapper> response) {
                    BusiRegsWrapper data= response.body();
                    if (response.isSuccessful())
                    {
                        if(data.getStatus().equals(Common.SUCCESS))
                        {
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                            recy_category_list.setLayoutManager(layoutManager);
                            recy_category_list.setItemAnimator(new DefaultItemAnimator());
                            CategoryAdapter catListAdapter = new CategoryAdapter(data.getData(), getContext());
                            recy_category_list.setAdapter(catListAdapter);
                        }
                    }
                }
                @Override
                public void onFailure(Call<BusiRegsWrapper> call, Throwable throwable) {
                    GlobalMethods.fetchErrorMessage(throwable,getActivity());
                    Toast.makeText(getActivity(),"Please Connect Internet",Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}