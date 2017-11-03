package com.ntrlab.ntrlabtest.models;

/**
 * Created by _red_ on 03/11/2017.
 */

public class Status {
    private String objectID;
    private String tag;

    public Status() {}

    public Status(String objectID, String tag) {
        this.objectID = objectID;
        this.tag = tag;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
