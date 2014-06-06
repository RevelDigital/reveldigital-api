package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Playlist;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_PLAYLISTS;

/**
 * Created by Mike on 6/5/2014.
 */
public class PlaylistService extends RevelService {

    /**
     * Create playlist service
     */
    public PlaylistService() {
        super();
    }

    /**
     * Create playlist service for client
     *
     * @param client
     */
    public PlaylistService(RevelClient client) {
        super(client);
    }

    /**
     * Get all playlists
     *
     * @return
     * @throws java.io.IOException
     */
    public List<Playlist> getPlaylists() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_PLAYLISTS);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Playlist>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get playlist by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public Playlist getPlaylist(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_PLAYLISTS);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Playlist>>() {
        }.getType());

        List<Playlist> ret = client.get(request);
        if (ret == null || ret.size() == 0) {
            return null;
        } else {
            return ret.get(0);
        }
    }
}
