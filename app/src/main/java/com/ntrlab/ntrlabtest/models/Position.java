package com.ntrlab.ntrlabtest.models;

/**
 * Created by _red_ on 03/11/2017.
 */

public class Position {
    private String latitude;
    private String longtitude;

    public Position() {}

    public Position(String latitude, String longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
}
