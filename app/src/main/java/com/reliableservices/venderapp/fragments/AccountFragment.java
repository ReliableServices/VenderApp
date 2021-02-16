package com.reliableservices.venderapp.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reliableservices.venderapp.R;


public class AccountFragment extends Fragment {
          private TextView support_aleart,iaudit_pc;

    public AccountFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        start(view);
        process();
        return view;
    }

    private void start(View view) {
        support_aleart = view.findViewById(R.id.support_aleart);
        iaudit_pc = view.findViewById(R.id.iaudit_pc);
    }

    private void process() {
        support_aleart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.support_aleart_dialog, null);
                builder.setView(dialogView);
               AlertDialog alertDialog = builder.create();
                alertDialog.show();
                TextView live_chat = dialogView.findViewById(R.id.live_chat);
                TextView call = dialogView.findViewById(R.id.call);
                TextView choose_support = dialogView.findViewById(R.id.choose_support);
                choose_support.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
            }
        });


        iaudit_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.iaudit_for_pc, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                TextView message = dialogView.findViewById(R.id.message);
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
            }
        });
    }
}