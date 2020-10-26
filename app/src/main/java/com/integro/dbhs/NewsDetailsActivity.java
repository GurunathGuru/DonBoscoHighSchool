package com.integro.dbhs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.integro.dbhs.model.News;

import java.util.ArrayList;

public class NewsDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        int position = (int) getIntent().getSerializableExtra("position");
        ArrayList<News> newsArrayList = (ArrayList<News>) getIntent().getSerializableExtra("NEWS");

        ImageView ivImage = findViewById(R.id.ivImage);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvShare = findViewById(R.id.tvShare);

        Glide.with(getApplicationContext())
                .load(newsArrayList.get(position).getImage())
                .into(ivImage);

        tvDate.setText(newsArrayList.get(position).getDate());
        tvTitle.setText(newsArrayList.get(position).getTitle());
        tvDescription.setText(newsArrayList.get(position).getDescription());

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "http://www.dbhspanjim.com/dbhspanjim_app/newshare.php?id" + newsArrayList.get(position).getId());
                startActivity(intent);
            }
        });
    }
}
