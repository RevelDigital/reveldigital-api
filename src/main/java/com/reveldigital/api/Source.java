package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class Source {

    private String id;
    private String name;
    private String type;
    private int sequence;
    @SerializedName("media_id")
    private String mediaId;
    private String value;
    private int interval;
    private Media media;
    private List<Condition> conditions;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSequence() {
        return sequence;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getValue() {
        return value;
    }

    public int getInterval() {
        return interval;
    }

    public Media getMedia() {
        return media;
    }

    public List<Condition> getConditions() {
        return conditions;
    }
}
