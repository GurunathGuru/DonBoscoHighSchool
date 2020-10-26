package com.integro.dbhs.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.integro.dbhs.NewsActivity;
import com.integro.dbhs.R;
import com.integro.dbhs.adapters.NewsAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.News;
import com.integro.dbhs.model.NewsList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {
    private static final String TAG = "NewsActivity";
    private RecyclerView rvNews;
    private ArrayList<News> newsArrayList;
    private NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news, container, false);
        rvNews = view.findViewById(R.id.rvNews);
        newsArrayList = new ArrayList<>();
        getNewsList();
        return view;
    }
    public void getNewsList() {
        String date = "2020-02-25 23:54:43";
        Call<NewsList> newsListCall =  ApiClients.getClients().create(ApiServices.class).getNewsList(date);
        newsListCall.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                if (!response.isSuccessful()) {
                    Log.i(TAG, "onResponse: not success");
                    return;
                }
                if (response.body().getNewsArrayList() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }
                Log.i(TAG, "onResponse: "+response.body().getNewsArrayList().size());
                int size = response.body().getNewsArrayList().size();
                for (int i=0; i < size; i++) {
                    newsArrayList.add(response.body().getNewsArrayList().get(i));
                }
                rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new NewsAdapter(getContext(),newsArrayList);
                rvNews.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
