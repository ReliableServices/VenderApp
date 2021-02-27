package com.reliableservices.venderapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.adpters.OrderAllAdapter;
import com.reliableservices.venderapp.adpters.PendingOrderAdapter;

import java.util.ArrayList;
import java.util.Collections;

import static com.reliableservices.venderapp.R.drawable.background_lite_gray_roundshape;
import static com.reliableservices.venderapp.R.drawable.btn_status_background;


public class Homefragment extends Fragment {
       private  TextView pending,accepted,shipped,view_all,empty_msg;
       private RecyclerView recycler_p_a_s;


    public Homefragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_homefragment, container, false);
        start(view);
        process();
        return view;
    }

    private void start(View view) {
    pending = view.findViewById(R.id.pending);
    accepted = view.findViewById(R.id.accepted);
    shipped = view.findViewById(R.id.shipped);
    view_all = view.findViewById(R.id.view_all);
    recycler_p_a_s = view.findViewById(R.id.recycler_p_a_s);
    empty_msg = view.findViewById(R.id.empty_msg);
    }


    private void process() {
        view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment, new OrderFragment());
                transaction.commit();
            }
        });
        pending.setTextColor(getResources().getColor(R.color.white));
        pending.setBackgroundResource(btn_status_background);
        empty_msg.setVisibility(View.VISIBLE);
        recycler_p_a_s.setVisibility(View.GONE);
        pending.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               changeBg(pending);
                empty_msg.setVisibility(View.VISIBLE);
                recycler_p_a_s.setVisibility(View.GONE);
             /*
                String [] catname =  {"Poco"};
                ArrayList<String> orederList = new ArrayList<>();
                Collections.addAll(orederList, catname);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                recycler_p_a_s.setLayoutManager(layoutManager);
                recycler_p_a_s.setItemAnimator(new DefaultItemAnimator());
                PendingOrderAdapter pendingOrderAdapter = new PendingOrderAdapter(orederList, getContext());
                recycler_p_a_s.setAdapter(pendingOrderAdapter);*/
            }
        });

        accepted.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changeBg(accepted);
                String [] catname =  {"moto","samsung"};
                recycler_p_a_s.setVisibility(View.VISIBLE);
                empty_msg.setVisibility(View.GONE);
                ArrayList<String> orederList = new ArrayList<>();
                Collections.addAll(orederList, catname);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                recycler_p_a_s.setLayoutManager(layoutManager);
                recycler_p_a_s.setItemAnimator(new DefaultItemAnimator());
                PendingOrderAdapter pendingOrderAdapter = new PendingOrderAdapter(orederList, getContext());
                recycler_p_a_s.setAdapter(pendingOrderAdapter);
            }
        });
        shipped.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                changeBg(shipped);
                recycler_p_a_s.setVisibility(View.VISIBLE);
                empty_msg.setVisibility(View.GONE);
                String [] catname =  {"Poco", "samsung", "VIVO Pro", "Oppo"};
                ArrayList<String> orederList = new ArrayList<>();
                Collections.addAll(orederList, catname);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                recycler_p_a_s.setLayoutManager(layoutManager);
                recycler_p_a_s.setItemAnimator(new DefaultItemAnimator());
                PendingOrderAdapter pendingOrderAdapter = new PendingOrderAdapter(orederList, getContext());
                recycler_p_a_s.setAdapter(pendingOrderAdapter);
            }
        });

    }

    private void changeBg(TextView textView)
    {
        pending.setBackgroundResource(background_lite_gray_roundshape);
        pending.setTextColor(getResources().getColor(R.color.black));
        accepted.setBackgroundResource(background_lite_gray_roundshape);
        accepted.setTextColor(getResources().getColor(R.color.black));
        shipped.setBackgroundResource(background_lite_gray_roundshape);
        shipped.setTextColor(getResources().getColor(R.color.black));
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setBackgroundResource(btn_status_background);
    }
}