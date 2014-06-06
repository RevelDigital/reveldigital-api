package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class Playlist {

    private String id;
    private String name;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("group_id")
    private String groupId;
    private String tags;
    private String type;
    private List<Source> sources;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTags() {
        return tags;
    }

    public String getType() {
        return type;
    }

    public List<Source> getSources() {
        return sources;
    }
}
