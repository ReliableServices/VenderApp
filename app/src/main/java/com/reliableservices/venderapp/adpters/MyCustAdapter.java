package com.reliableservices.venderapp.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reliableservices.venderapp.R;

import java.util.ArrayList;

public class MyCustAdapter extends RecyclerView.Adapter<MyCustAdapter.ViewHolder> {
    ArrayList<String> castArrayList;
    Context context;

    public MyCustAdapter(ArrayList<String> castArrayList, Context context) {
        this.castArrayList = castArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cust_list_viewholder, parent, false);
        return new MyCustAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String m = castArrayList.get(position);
        holder.cust_name.setText(m);
    }

    @Override
    public int getItemCount() {
        return castArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cust_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cust_name = itemView.findViewById(R.id.cust_name);
        }
    }
}
