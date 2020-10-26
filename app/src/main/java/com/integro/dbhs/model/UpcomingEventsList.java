package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UpcomingEventsList {

    @SerializedName("dbhs_events")
    private ArrayList<UpcomingEvents> upcomingEventsArrayList;

    public ArrayList<UpcomingEvents> getUpcomingEventsArrayList() {
        return upcomingEventsArrayList;
    }

    public void setUpcomingEventsArrayList(ArrayList<UpcomingEvents> upcomingEventsArrayList) {
        this.upcomingEventsArrayList = upcomingEventsArrayList;
    }

    private String success;

    private String message;

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
