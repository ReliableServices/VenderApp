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

public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderAdapter.ViewHolder> {
    ArrayList<String> pendingOrderArray;
    Context context;
    public PendingOrderAdapter(ArrayList<String> pendingOrderArray, Context context) {
        this.pendingOrderArray = pendingOrderArray;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_view_holder, parent, false);
        return new PendingOrderAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String m = pendingOrderArray.get(position);
        holder.item.setText(m);
        holder.cust_detail.setOnClickListener(new View.OnClickListener() {
                                                          @Override
                                                          public void onClick(View v) {
                                                              Intent i = new Intent(context, CustomDetailActivity.class);
                                                              context.startActivity(i);
                                                          }
                                                    });
    }
    @Override
    public int getItemCount() {
        return pendingOrderArray.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item,cust_detail,shipped,accept,delivered;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            cust_detail = itemView.findViewById(R.id.cust_detail);
            shipped  = itemView.findViewById(R.id.shipped);
            accept = itemView.findViewById(R.id.accept);
            delivered = itemView.findViewById(R.id.delivered);

        }
    }
}