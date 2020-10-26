package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnnouncementList {

    @SerializedName("dbhs_announcement")
    private ArrayList<Announcement> announcementArrayList;

    private String success;

    private String message;

    public ArrayList<Announcement> getAnnouncementArrayList() {
        return announcementArrayList;
    }

    public void setAnnouncementArrayList(ArrayList<Announcement> announcementArrayList) {
        this.announcementArrayList = announcementArrayList;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }
}
