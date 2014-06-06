package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.User;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_USERS;

/**
 * Created by Mike on 6/5/2014.
 */
public class UserService extends RevelService {

    /**
     * Create user service
     */
    public UserService() {
        super();
    }

    /**
     * Create user service for client
     *
     * @param client
     */
    public UserService(RevelClient client) {
        super(client);
    }

    /**
     * Get all users
     *
     * @return
     * @throws java.io.IOException
     */
    public List<User> getUsers() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_USERS);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<User>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get user by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public User getUser(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_USERS);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<User>>() {
        }.getType());

        List<User> ret = client.get(request);
        if (ret == null || ret.size() == 0) {
            return null;
        } else {
            return ret.get(0);
        }
    }
}
