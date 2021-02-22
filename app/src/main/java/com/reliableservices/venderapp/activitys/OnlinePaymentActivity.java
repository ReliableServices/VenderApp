package com.reliableservices.venderapp.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.reliableservices.venderapp.R;

public class OnlinePaymentActivity extends AppCompatActivity {
    private RadioGroup payment_method;
    private LinearLayout linear_bank,linear_upi;
    private CheckBox checkBox;
    private TextView btn_verify_bank;
    private ImageView payment_query,back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_payment);
        start();
        process();
    }

    private void start() {
        back_btn  =findViewById(R.id.back_btn);
        payment_method = findViewById(R.id.payment_method);
        linear_bank = findViewById(R.id.linear_bank);
        linear_upi = findViewById(R.id.linear_upi);
        checkBox = findViewById(R.id.checkBox);
        btn_verify_bank = findViewById(R.id.btn_verify_bank);
        payment_query = findViewById(R.id.payment_query);
    }

    private void process() {
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        payment_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OnlinePaymentActivity.this);
                View dialogView = LayoutInflater.from(OnlinePaymentActivity.this).inflate(R.layout.bank_query_dialog, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                TextView choose_support = dialogView.findViewById(R.id.choose_support);
                choose_support.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
            }
        });

        payment_method.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                // Add logic here
                switch (index) {
                    case 0: // first button
                        linear_upi.setVisibility(View.VISIBLE);
                        linear_bank.setVisibility(View.GONE);
                        btn_verify_bank.setText("Verify UPI");
                        break;
                    case 1: // secondbutton
                        linear_upi.setVisibility(View.GONE);
                        linear_bank.setVisibility(View.VISIBLE);
                        btn_verify_bank.setText("Verify Bank Details");
                        break;
                }
            }
        });



        if(checkBox.isChecked())
        {
            Toast.makeText(this, "check button checked ", Toast.LENGTH_SHORT).show();
        }else{

        }
    }
}