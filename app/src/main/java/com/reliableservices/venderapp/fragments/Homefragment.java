package com.reliableservices.venderapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reliableservices.venderapp.R;

import static com.reliableservices.venderapp.R.drawable.background_lite_gray_roundshape;
import static com.reliableservices.venderapp.R.drawable.btn_status_background;


public class Homefragment extends Fragment {
       private  TextView pending,accepted,shipped;


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
    }

    private void process() {
        pending.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
               changeBg(pending);
            }
        });

        accepted.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                changeBg(accepted);
            }
        });
        shipped.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                changeBg(shipped);
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