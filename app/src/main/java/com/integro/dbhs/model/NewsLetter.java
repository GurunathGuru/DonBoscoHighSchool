package com.integro.dbhs.model;

import java.io.Serializable;

public class NewsLetter implements Serializable {

    private String date;

    private String image;

    private String pdf;

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

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getPdf ()
    {
        return pdf;
    }

    public void setPdf (String pdf)
    {
        this.pdf = pdf;
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
