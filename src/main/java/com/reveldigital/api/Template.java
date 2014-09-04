package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class Template implements Serializable {

    private String id;
    private String name;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("group_id")
    private String groupId;
    private String tags;
    private Date createdOn;
    private String createdById;
    private Date modifiedOn;
    private String modifiedById;
    private String script;
    private String backColor;
    private int width;
    private int height;
    private int orientation;
    private List<Module> modules;

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

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getCreatedById() {
        return createdById;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedById() {
        return modifiedById;
    }

    public String getScript() {
        return script;
    }

    public String getBackColor() {
        return backColor;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getOrientation() {
        return orientation;
    }

    public List<Module> getModules() {
        return modules;
    }
}
