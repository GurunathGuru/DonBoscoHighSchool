package com.integro.dbhs;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.dbhs.adapters.AnnouncementAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.Announcement;
import com.integro.dbhs.model.AnnouncementList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnnouncementActivity extends AppCompatActivity {
    private static final String TAG = "AnnouncementActivity";
    private RecyclerView rvAnnouncement;
    private ArrayList<Announcement> announcementArrayList;
    private AnnouncementAdapter adapter;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        rvAnnouncement = findViewById(R.id.rvAnnouncements);
        announcementArrayList = new ArrayList<>();
        manager=new LinearLayoutManager(this);
        getAnnouncement();
    }

    public void getAnnouncement() {
        Call<AnnouncementList> announcementListCall = ApiClients.getClients().create(ApiServices.class).getAnnouncementList();
        announcementListCall.enqueue(new Callback<AnnouncementList>() {
            @Override
            public void onResponse(Call<AnnouncementList> call, Response<AnnouncementList> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "onResponse: response fail");
                    return;
                }
                if (response.body().getAnnouncementArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    Toast.makeText(AnnouncementActivity.this, "No items fond", Toast.LENGTH_SHORT).show();
                    return;
                }
                int size = response.body().getAnnouncementArrayList().size();
                Log.i(TAG, "onResponse: " + size);
                for (int i = 0; i < size; i++) {
                    announcementArrayList.add(response.body().getAnnouncementArrayList().get(i));
                }
                rvAnnouncement.setLayoutManager(manager);
                adapter = new AnnouncementAdapter(getApplicationContext(), announcementArrayList);
                rvAnnouncement.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<AnnouncementList> call, Throwable t) {
                Toast.makeText(AnnouncementActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
