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

package com.reveldigital.api.service;

import com.reveldigital.api.Playlist;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.service.retrofit.PlaylistInterface;
import retrofit.Callback;

import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class PlaylistService extends BaseService<PlaylistInterface> {

    public List<Playlist> getPlaylists() throws RequestException {
        return wrapper.getPlaylists();
    }

    public void getPlaylists(Callback<List<Playlist>> callback) throws RequestException {
        wrapper.getPlaylists(callback);
    }

    public Playlist getPlaylist(String id) throws RequestException {
        return wrapper.getPlaylist(id);
    }

    public void getPlaylist(String id, Callback<Playlist> callback) throws RequestException {
        wrapper.getPlaylist(id, callback);
    }

    public static class Builder extends BaseService.Builder {

        public PlaylistService build() {
            PlaylistService service = new PlaylistService();
            service.wrapper = build(PlaylistInterface.class);
            return service;
        }
    }
}
