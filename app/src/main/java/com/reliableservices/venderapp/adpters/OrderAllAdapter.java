package com.reliableservices.venderapp.adpters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reliableservices.venderapp.R;
import com.reliableservices.venderapp.activitys.CustomDetailActivity;

import java.util.ArrayList;

public class OrderAllAdapter extends RecyclerView.Adapter<OrderAllAdapter.ViewHolder> {
    ArrayList<String> categoryArrayList;
    Context context;

    public OrderAllAdapter(ArrayList<String> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_view_holder,parent,false);
        return new OrderAllAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String m = categoryArrayList.get(position);
        holder.item.setText(m);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CustomDetailActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);

        }
    }
}
