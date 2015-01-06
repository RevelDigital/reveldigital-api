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

import com.reveldigital.api.Playlist;
import com.reveldigital.api.RequestException;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_PLAYLISTS;

/**
 * Created by Mike on 1/5/2015.
 */
public interface PlaylistInterface {

    @GET(SEGMENT_PLAYLISTS)
    List<Playlist> getPlaylists() throws RequestException;

    @GET(SEGMENT_PLAYLISTS)
    void getPlaylists(Callback<List<Playlist>> callback) throws RequestException;

    @GET(SEGMENT_PLAYLISTS + "/{id}")
    Playlist getPlaylist(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_PLAYLISTS + "/{id}")
    void getPlaylist(@Path("id") String id, Callback<Playlist> callback) throws RequestException;
}
