/*
 * Copyright (c) 2016. Catalyst LLC. All right reserved.
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

package com.reveldigital.api.service;

import com.reveldigital.api.Media;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.service.retrofit.MediaInterface;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Callback;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static com.reveldigital.api.IConstants.DATE_FORMAT;

/**
 * Created by Mike on 1/5/2015.
 */
public class MediaService extends BaseService<MediaInterface> {

    public List<Media> getMedias() throws RequestException, IOException {
        return verifyResponse(wrapper.getMedias().execute());
    }

    public void getMedias(Callback<List<Media>> callback) throws RequestException {
        wrapper.getMedias().enqueue(callback);
    }

    public Media getMedia(String id) throws RequestException, IOException {
        return verifyResponse(wrapper.getMedia(id).execute());
    }

    public void getMedia(String id, Callback<Media> callback) throws RequestException {
        wrapper.getMedia(id).enqueue(callback);
    }

    public Media createMedia(Media media, File file) throws RequestException, IOException {

        if (media.getGroupId() == null)
            throw new IllegalArgumentException("Group Id is required");

        HashMap<String, String> params = new HashMap<>();
        params.put("group_id", media.getGroupId());
        params.put("shared", media.isShared() ? "true" : "false");
        if (media.getStartDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            params.put("start_date", sdf.format(media.getStartDate()));
        }
        if (media.getEndDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            params.put("end_date", sdf.format(media.getEndDate()));
        }
        if (media.getAdvertiserId() != null) {
            params.put("advertiser_id", media.getAdvertiserId());
        }
        if (media.getName() != null) {
            params.put("name", media.getName());
        }
        if (media.getTags() != null) {
            params.put("description", media.getTags());
        }

        HashMap<String, RequestBody> map = new HashMap<>();
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        map.put("file\"; filename=\"" + file.getName(), body);

        return verifyResponse(wrapper.createMedia(map, params).execute());
    }

    public void createMedia(Media media, File file, Callback<Media> callback) throws RequestException {

        if (media.getGroupId() == null)
            throw new IllegalArgumentException("Group Id is required");

        HashMap<String, String> params = new HashMap<>();
        params.put("group_id", media.getGroupId());
        params.put("shared", media.isShared() ? "true" : "false");
        if (media.getStartDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            params.put("start_date", sdf.format(media.getStartDate()));
        }
        if (media.getEndDate() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            params.put("end_date", sdf.format(media.getEndDate()));
        }
        if (media.getAdvertiserId() != null) {
            params.put("advertiser_id", media.getAdvertiserId());
        }
        if (media.getName() != null) {
            params.put("name", media.getName());
        }
        if (media.getTags() != null) {
            params.put("description", media.getTags());
        }

        HashMap<String, RequestBody> map = new HashMap<>();
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        map.put("file\"; filename=\"" + file.getName(), body);

        wrapper.createMedia(map, params).enqueue(callback);
    }

    public static class Builder extends BaseService.Builder {

        public MediaService build() {
            MediaService service = new MediaService();
            service.wrapper = build(MediaInterface.class);
            return service;
        }
    }
}
