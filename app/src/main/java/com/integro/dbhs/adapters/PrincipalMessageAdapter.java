package com.integro.dbhs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.dbhs.R;
import com.integro.dbhs.model.PrincipalMessage;

import java.util.ArrayList;

public class PrincipalMessageAdapter extends RecyclerView.Adapter<PrincipalMessageAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<PrincipalMessage> principalMessageArrayList;

    public PrincipalMessageAdapter(Context context, ArrayList<PrincipalMessage> principalMessageArrayList) {
        this.context = context;
        this.principalMessageArrayList = principalMessageArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_princepal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .load(principalMessageArrayList.get(position).getImage())
                .into(holder.ivImage);
        holder.tvTitle.setText(principalMessageArrayList.get(position).getName());
        holder.tvDescription.setText(principalMessageArrayList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return principalMessageArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle,
                tvDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
