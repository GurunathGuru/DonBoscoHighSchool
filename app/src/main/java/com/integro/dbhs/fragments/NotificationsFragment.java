package com.integro.dbhs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.integro.dbhs.R;
import com.integro.dbhs.adapters.NotificationAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.Notification;
import com.integro.dbhs.model.NotificationList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsFragment extends Fragment {

    private static final String TAG = "NotificationsFragment";
    private ArrayList<Notification> notificationArrayList;
    private RecyclerView rvNotifications;
    private NotificationAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notifications, container, false);

        rvNotifications = view.findViewById(R.id.rvNotifications);
        notificationArrayList = new ArrayList<>();
        rvNotifications.setLayoutManager( new LinearLayoutManager(getContext()));
        getNotifications();
        return view;
    }

    public void getNotifications() {
        String date = "2020-02-26 23:16:07";
        Call<NotificationList> notificationListCall = ApiClients.getClients().create(ApiServices.class).getNotificationList(date);
        notificationListCall.enqueue(new Callback<NotificationList>() {
            @Override
            public void onResponse(Call<NotificationList> call, Response<NotificationList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getNotificationArrayList() == null) {
                    return;
                }
                Log.d(TAG, "onResponse: size"+response.body().getNotificationArrayList().size());
                int size = response.body().getNotificationArrayList().size();
                for (int i=0; i < size; i++) {
                    notificationArrayList.add(response.body().getNotificationArrayList().get(i));
                }
                adapter = new NotificationAdapter(getContext(), notificationArrayList);
                rvNotifications.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NotificationList> call, Throwable t) {

            }
        });
    }

}
