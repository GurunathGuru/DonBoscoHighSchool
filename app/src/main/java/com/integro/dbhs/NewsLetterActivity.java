package com.integro.dbhs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.dbhs.adapters.NewsLetterAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.NewsLetter;
import com.integro.dbhs.model.NewsLetterList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsLetterActivity extends AppCompatActivity {

    private RecyclerView rvNewsLetter;
    private ArrayList<NewsLetter> newsLetterArrayList;
    private NewsLetterAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_letter);

        rvNewsLetter = findViewById(R.id.rvNewsLetter);
        newsLetterArrayList = new ArrayList<>();
        rvNewsLetter.setLayoutManager(new LinearLayoutManager(this));
        getNewsLetter();
    }

    public void getNewsLetter() {
        String date = "2020-02-26 23:38:08";
        Call<NewsLetterList> newsLetterListCall = ApiClients.getClients().create(ApiServices.class).getNewsLetterList(date);
        newsLetterListCall.enqueue(new Callback<NewsLetterList>() {
            @Override
            public void onResponse(Call<NewsLetterList> call, Response<NewsLetterList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getNewsLetterArrayList() == null) {
                    return;
                }
                int size = response.body().getNewsLetterArrayList().size();

                for (int i = 0; i < size; i++) {
                    newsLetterArrayList.add(response.body().getNewsLetterArrayList().get(i));
                }
                adapter = new NewsLetterAdapter(getApplicationContext(), newsLetterArrayList);
                rvNewsLetter.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NewsLetterList> call, Throwable t) {

            }
        });
    }
}
