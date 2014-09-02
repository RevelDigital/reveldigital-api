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

    /**
     * Update user
     *
     * @param user
     * @return
     * @throws java.io.IOException
     */
    public User updateUser(User user) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_USERS);
        uri.append('/').append(user.getId());

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(User.class);
        request.setBody(user);

        return client.put(request);
    }

    /**
     * Create new user
     *
     * @param user
     * @return
     * @throws IOException
     */
    public User createUser(String userName, String password, User user) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_USERS);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(UserRequest.class);
        request.setBody(new UserRequest(userName, password, user));

        return client.post(request);
    }

    private class UserRequest extends User {

        private final String password;

        public UserRequest(String userName, String password, User user) {
            super.userName = userName;
            this.password = password;

            if (userName == null)
                throw new IllegalArgumentException("Username is required");
            if (password == null)
                throw new IllegalArgumentException("Password is required");
            if (user.getEmail() == null)
                throw new IllegalArgumentException("Email is required");

            setFirstName(user.getFirstName());
            setLastName(user.getLastName());
            setCity(user.getCity());
            setState(user.getState());
            setPostalCode(user.getPostalCode());
            setCountry(user.getCountry());
            setHomePhone(user.getHomePhone());
            setWorkPhone(user.getWorkPhone());
            setMobilePhone(user.getMobilePhone());
            setEmail(user.getEmail());
            setRoles(user.getRoles());
        }
    }
}
