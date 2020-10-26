package com.integro.dbhs.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PrincipalMessageList {

    private String success;

    @SerializedName("dbhs_principal")
    private ArrayList<PrincipalMessage> principalMessageArrayList;

    private String message;

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public ArrayList<PrincipalMessage> getPrincipalMessageArrayList() {
        return principalMessageArrayList;
    }

    public void setPrincipalMessageArrayList(ArrayList<PrincipalMessage> principalMessageArrayList) {
        this.principalMessageArrayList = principalMessageArrayList;
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
