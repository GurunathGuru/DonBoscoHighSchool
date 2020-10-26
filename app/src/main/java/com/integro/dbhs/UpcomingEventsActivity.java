package com.integro.dbhs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.dbhs.adapters.UpcomingEventsAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.UpcomingEvents;
import com.integro.dbhs.model.UpcomingEventsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpcomingEventsActivity extends AppCompatActivity {

    private RecyclerView rvUpComingEvents;
    private ArrayList<UpcomingEvents> upcomingEventsArrayList;
    private UpcomingEventsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomin_events);

        rvUpComingEvents = findViewById(R.id.rvUpcomingEvents);
        upcomingEventsArrayList = new ArrayList<>();
        rvUpComingEvents.setLayoutManager(new LinearLayoutManager(this));
        getUpComingEventsList();
    }

    public void getUpComingEventsList() {
        String date = "2020-02-26 23:43:27";
        Call<UpcomingEventsList> upcomingEventsListCall = ApiClients.getClients().create(ApiServices.class).getUpcomingEventsList(date);
        upcomingEventsListCall.enqueue(new Callback<UpcomingEventsList>() {
            @Override
            public void onResponse(Call<UpcomingEventsList> call, Response<UpcomingEventsList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getUpcomingEventsArrayList() == null) {
                    return;
                }
                int size = response.body().getUpcomingEventsArrayList().size();
                for (int i = 0; i < size; i++) {
                    upcomingEventsArrayList.add(response.body().getUpcomingEventsArrayList().get(i));
                }
                adapter=new UpcomingEventsAdapter(getApplicationContext(),upcomingEventsArrayList);
                rvUpComingEvents.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UpcomingEventsList> call, Throwable t) {

            }
        });
    }
}
