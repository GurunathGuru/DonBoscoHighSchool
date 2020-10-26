package com.integro.dbhs.model;

import java.io.Serializable;

public class Announcement implements Serializable {

    private String date;

    private String url_pdf;

    private String updated_at;

    private String id;

    private String title;

    public String getDate ()
    {
        return date;
    }

    public void setDate (String date)
    {
        this.date = date;
    }

    public String getUrl_pdf ()
    {
        return url_pdf;
    }

    public void setUrl_pdf (String url_pdf)
    {
        this.url_pdf = url_pdf;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }
}
