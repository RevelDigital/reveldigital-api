/*
 * Copyright (c) 2015. Catalyst LLC. All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mike on 6/5/2014.
 */
public class Media implements Serializable {

    private String id;
    private String name;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("group_id")
    private String groupId;
    private String tags;
    @SerializedName("mime_type")
    private String mimeType;
    @SerializedName("file_size")
    private int fileSize;
    @SerializedName("file_name")
    private String fileName;
    @SerializedName("file_url")
    private String fileUrl;
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;
    @SerializedName("uploaded_on")
    private Date uploadedOn;
    @SerializedName("uploaded_by")
    private String uploadedBy;
    @SerializedName("advertise_id")
    private String advertiserId;
    @SerializedName("is_shared")
    private boolean isShared;
    @SerializedName("start_date")
    private Date startDate;
    @SerializedName("end_date")
    private Date endDate;


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

    public String getMimeType() {
        return mimeType;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Date getUploadedOn() {
        return uploadedOn;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public boolean isShared() {
        return isShared;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Media setName(String name) {
        this.name = name;
        return this;
    }

    public Media setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Media setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Media setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
        return this;
    }

    public Media setShared(boolean isShared) {
        this.isShared = isShared;
        return this;
    }

    public Media setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Media setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Media setMimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }
}
