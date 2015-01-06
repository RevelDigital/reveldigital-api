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
import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class Source implements Serializable {

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
