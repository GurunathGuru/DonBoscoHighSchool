package com.integro.dbhs.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.dbhs.R;
import com.integro.dbhs.model.NewsLetter;

import java.util.ArrayList;

public class NewsLetterAdapter extends RecyclerView.Adapter<NewsLetterAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<NewsLetter> newsLetterArrayList;

    public NewsLetterAdapter(Context context, ArrayList<NewsLetter> newsLetterArrayList) {
        this.context = context;
        this.newsLetterArrayList = newsLetterArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_news_letter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(newsLetterArrayList.get(position).getImage()).into(holder.ivImage);
        holder.tvDate.setText(newsLetterArrayList.get(position).getDate());
        holder.tvTitle.setText(newsLetterArrayList.get(position).getTitle());

        holder.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(newsLetterArrayList.get(position).getPdf()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsLetterArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvTitle, tvDate, tvDownload;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDownload = itemView.findViewById(R.id.tvDownload);
        }
    }
}
