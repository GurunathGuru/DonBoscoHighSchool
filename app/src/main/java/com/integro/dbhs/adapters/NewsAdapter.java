package com.integro.dbhs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.dbhs.NewsDetailsActivity;
import com.integro.dbhs.R;
import com.integro.dbhs.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context context;
    ArrayList<News> newsArrayList;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context=context;

        this.newsArrayList=newsArrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_news,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.MyViewHolder holder, int position) {

        Glide.with(context)
                .load(newsArrayList.get(position).getImage())
                .into(holder.ivImage);

        holder.tvDate.setText(newsArrayList.get(position).getDate());
        holder.tvTitle.setText(newsArrayList.get(position).getTitle());
        holder.tvDescription.setText(newsArrayList.get(position).getDescription());

        holder.cardViewNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, NewsDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("position",position);
                intent.putExtra("NEWS",newsArrayList);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardViewNews;
        ImageView ivImage;
        TextView tvTitle,tvDate,tvDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage=itemView.findViewById(R.id.ivImage);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            cardViewNews=itemView.findViewById(R.id.crNews);
        }
    }
}
