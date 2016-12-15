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

package com.reveldigital.api.service.retrofit;

import com.reveldigital.api.Group;
import com.reveldigital.api.Media;
import com.reveldigital.api.RequestException;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

import static com.reveldigital.api.IConstants.SEGMENT_DEVICES;
import static com.reveldigital.api.IConstants.SEGMENT_MEDIA;

/**
 * Created by Mike on 1/5/2015.
 */
public interface MediaInterface {

    @GET(SEGMENT_MEDIA)
    Call<List<Media>> getMedias() throws RequestException;

    @GET(SEGMENT_MEDIA + "/{id}")
    Call<Media> getMedia(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_MEDIA + "/groups")
    Call<List<Group>> getGroups() throws RequestException;

//
//    @POST(SEGMENT_MEDIA + "/{group_id}/{file_name}")
//    Call<Media> createMedia(@Path("group_id") String groupId, @Path("file_name") String fileName, @Body RequestBody file,
//                            @QueryMap Map<String, String> params) throws RequestException;

    @Multipart
    @POST(SEGMENT_MEDIA)
    Call<Media> createMedia(@PartMap Map<String, RequestBody> media, @QueryMap Map<String, String> params) throws RequestException;
}
