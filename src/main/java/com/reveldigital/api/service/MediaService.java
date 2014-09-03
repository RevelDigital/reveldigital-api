package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Media;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import static com.reveldigital.api.client.IConstants.DATE_FORMAT;
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
     * @throws IOException
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

    /**
     * Create new media
     *
     * @param media
     * @param file
     * @return
     * @throws IOException
     */
    public Media createMedia(Media media, File file) throws IOException {
        if (media.getGroupId() == null)
            throw new IllegalArgumentException("Group Id is required");

        StringBuilder uri = new StringBuilder(SEGMENT_MEDIA);
        uri.append('/').append(media.getGroupId());
        uri.append('/').append(file.getName());

        HashMap<String, String> params = new HashMap<String, String>();
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
        RevelRequest request = createRequest(params);
        request.setUri(uri).setFile(file).setType(Media.class);

        return client.post(request);
    }
}
