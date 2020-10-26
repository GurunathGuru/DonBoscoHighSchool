package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsList {

    @SerializedName("dbhs_news")
    private ArrayList<News> newsArrayList;

    private String success;

    private String message;

    public ArrayList<News> getNewsArrayList() {
        return newsArrayList;
    }

    public void setNewsArrayList(ArrayList<News> newsArrayList) {
        this.newsArrayList = newsArrayList;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
