package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CoverPhotosList {

    private String success;

    private String message;

    @SerializedName("dbhs_coverphoto")
    private ArrayList<CoverPhotos> coverPhotosArrayList;

    public ArrayList<CoverPhotos> getCoverPhotosArrayList() {
        return coverPhotosArrayList;
    }

    public void setCoverPhotosArrayList(ArrayList<CoverPhotos> coverPhotosArrayList) {
        this.coverPhotosArrayList = coverPhotosArrayList;
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
