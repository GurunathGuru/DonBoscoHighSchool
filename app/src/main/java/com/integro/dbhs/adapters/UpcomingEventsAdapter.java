package com.integro.dbhs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.integro.dbhs.R;
import com.integro.dbhs.model.UpcomingEvents;

import java.util.ArrayList;
import java.util.Calendar;

public class UpcomingEventsAdapter extends RecyclerView.Adapter<UpcomingEventsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<UpcomingEvents> upcomingEventsArrayList;

    public UpcomingEventsAdapter(Context context, ArrayList<UpcomingEvents> upcomingEventsArrayList) {
        this.context = context;
        this.upcomingEventsArrayList = upcomingEventsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_events, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(upcomingEventsArrayList.get(position).getImage())
                .into(holder.ivImage);

        holder.tvDate.setText(upcomingEventsArrayList.get(position).getDate());
        holder.tvTitle.setText(upcomingEventsArrayList.get(position).getTitle());
        holder.tvDescription.setText(upcomingEventsArrayList.get(position).getDescription());

        holder.tvAddToCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                intent.putExtra("beginTime", cal.getTimeInMillis());
                intent.putExtra("allDay", true);
                intent.putExtra("rrule", "FREQ=YEARLY");
                intent.putExtra("endTime", cal.getTimeInMillis() + 60 * 60 * 1000);
                intent.putExtra("title", "" + upcomingEventsArrayList.get(position).getTitle());
                intent.putExtra("description", "" + upcomingEventsArrayList.get(position).getDescription());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        holder.tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "http://www.dbhspanjim.com/dbhspanjim_app/eventshare.php?id="+upcomingEventsArrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return upcomingEventsArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitle, tvDate, tvDescription, tvShare, tvAddToCalender;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvAddToCalender = itemView.findViewById(R.id.tvAddToCalendar);
            tvShare = itemView.findViewById(R.id.tvShare);
        }
    }
}
