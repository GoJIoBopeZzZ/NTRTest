package com.ntrlab.ntrlabtest.models;

/**
 * Created by _red_ on 03/11/2017.
 */

public class NTRObject {
    private String name;
    private String title;
    private String objectID;

    public NTRObject() {}

    public NTRObject(String name, String title, String objectID) {
        this.name = name;
        this.title = title;
        this.objectID = objectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
}
