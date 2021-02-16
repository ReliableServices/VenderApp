package com.reliableservices.venderapp.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.fragments.AccountFragment;
import com.reliableservices.venderapp.fragments.Homefragment;
import com.reliableservices.venderapp.fragments.ManageFragment;
import com.reliableservices.venderapp.fragments.OrderFragment;
import com.reliableservices.venderapp.fragments.ProductFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
        process();
    }

    private void start() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void process() {
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.home:
                                selectedFragment = new Homefragment();
                                break;
                            case R.id.oders:
                                selectedFragment = new OrderFragment();;
                                break;
                            case R.id.products:
                                selectedFragment = new ProductFragment();
                                break;
                            case R.id.manage:
                                selectedFragment = new ManageFragment();
                                break;
                            case R.id.account:
                                selectedFragment = new AccountFragment();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, new Homefragment());
        transaction.commit();
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
    }



}