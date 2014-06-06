package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Media;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_MEDIA;

/**
 * Created by Mike on 6/5/2014.
 */
public class MediaService extends RevelService {

    /**
     * Create media service
     */
    public MediaService() {
        super();
    }

    /**
     * Create media service for client
     *
     * @param client
     */
    public MediaService(RevelClient client) {
        super(client);
    }

    /**
     * Get all media
     *
     * @return
     * @throws java.io.IOException
     */
    public List<Media> getMedias() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_MEDIA);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Media>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get media by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public Media getMedia(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_MEDIA);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Media>>() {
        }.getType());

        List<Media> ret = client.get(request);
        if (ret == null || ret.size() == 0) {
            return null;
        } else {
            return ret.get(0);
        }
    }
}
