package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mike on 6/5/2014.
 */
public class Module implements Serializable {

    private String id;
    private String name;
    private String type;
    private int left;
    private int top;
    private int width;
    private int height;
    @SerializedName("playlist_id")
    private String playlistId;
    private int sequence;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public int getSequence() {
        return sequence;
    }
}
