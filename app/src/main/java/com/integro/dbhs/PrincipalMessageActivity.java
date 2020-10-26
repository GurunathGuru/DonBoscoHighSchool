package com.integro.dbhs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.integro.dbhs.adapters.PrincipalMessageAdapter;
import com.integro.dbhs.apis.ApiClients;
import com.integro.dbhs.apis.ApiServices;
import com.integro.dbhs.model.PrincipalMessage;
import com.integro.dbhs.model.PrincipalMessageList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalMessageActivity extends AppCompatActivity {

    private RecyclerView rvPrincipal;
    private ArrayList<PrincipalMessage> principalMessageArrayList;
    private PrincipalMessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_message);

        rvPrincipal = findViewById(R.id.rvPrincipal);
        principalMessageArrayList = new ArrayList<>();
        rvPrincipal.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getPrincipalMessage();
    }

    private void getPrincipalMessage() {
        String date = "2020-02-27 00:06:07";
        Call<PrincipalMessageList> messageListCall = ApiClients.getClients().create(ApiServices.class).getPrincipalMessageList(date);
        messageListCall.enqueue(new Callback<PrincipalMessageList>() {
            @Override
            public void onResponse(Call<PrincipalMessageList> call, Response<PrincipalMessageList> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                if (response.body().getPrincipalMessageArrayList() == null) {
                    return;
                }
                int size = response.body().getPrincipalMessageArrayList().size();
                for (int i = 0; i < size; i++) {
                    principalMessageArrayList.add(response.body().getPrincipalMessageArrayList().get(i));
                }
                adapter=new PrincipalMessageAdapter(getApplicationContext(),principalMessageArrayList);
                rvPrincipal.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PrincipalMessageList> call, Throwable t) {

            }
        });
    }
}
