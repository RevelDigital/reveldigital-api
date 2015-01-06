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

package com.reveldigital.api.service.retrofit;

import com.reveldigital.api.Media;
import com.reveldigital.api.RequestException;
import retrofit.Callback;
import retrofit.http.*;
import retrofit.mime.TypedFile;

import java.util.List;
import java.util.Map;

import static com.reveldigital.api.IConstants.SEGMENT_MEDIA;

/**
 * Created by Mike on 1/5/2015.
 */
public interface MediaInterface {

    @GET(SEGMENT_MEDIA)
    List<Media> getMedias() throws RequestException;

    @GET(SEGMENT_MEDIA)
    void getMedias(Callback<List<Media>> callback) throws RequestException;

    @GET(SEGMENT_MEDIA + "/{id}")
    Media getMedia(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_MEDIA + "/{id}")
    void getMedia(@Path("id") String id, Callback<Media> callback) throws RequestException;

    @POST(SEGMENT_MEDIA + "/{group_id}/{file_name}")
    Media createMedia(@Path("group_id") String groupId, @Path("file_name") String fileName, @Body TypedFile file,
                      @QueryMap Map<String, String> params) throws RequestException;

    @POST(SEGMENT_MEDIA + "/{group_id}/{file_name}")
    void createMedia(@Path("group_id") String groupId, @Path("file_name") String fileName, @Body TypedFile file,
                     @QueryMap Map<String, String> params, Callback<Media> callback) throws RequestException;
}
