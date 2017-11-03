package com.ntrlab.ntrlabtest.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _red_ on 03/11/2017.
 */

public class Entity {
    private Position location;
    private List<NTRObject> objects = new ArrayList<>();

    public Entity() {}

    public Entity(Position location, List<NTRObject> objects) {
        this.location = location;
        this.objects = objects;
    }

    public Position getLocation() {
        return location;
    }

    public void setLocation(Position location) {
        this.location = location;
    }

    public List<NTRObject> getObjects() {
        return objects;
    }

    public void setObjects(List<NTRObject> objects) {
        this.objects = objects;
    }
}
