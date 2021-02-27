package com.reliableservices.venderapp.adpters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.FragmentTransitionSupport;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.fragments.ManageFragment;
import com.reliableservices.venderapp.fragments.OrderFragment;
import com.reliableservices.venderapp.fragments.ProductFragment;
import com.reliableservices.venderapp.fragments.ProductListFragment;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<String> categoryArrayList;
    Context context;

    public CategoryAdapter(ArrayList<String> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_list_viewholder, parent, false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String m = categoryArrayList.get(position);
        holder.item.setText(m);
        holder.cat_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout, new ProductListFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        CardView cat_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            cat_item = itemView.findViewById(R.id.cat_item);

        }
    }
}
