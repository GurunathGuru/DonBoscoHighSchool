package com.integro.dbhs.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClients {
    private static final String BASE_URL="https://www.dbhspanjim.edu.in/dbhspanjim_app/";
    private static Retrofit retrofit=null;
    public static Retrofit getClients(){
        if (retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
