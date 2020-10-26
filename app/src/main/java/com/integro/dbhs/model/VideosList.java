package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VideosList {
    private int success;

    @SerializedName("videos")
    private ArrayList<Videos> videos;

    private String message;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public ArrayList<Videos> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Videos> videos) {
        this.videos = videos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
