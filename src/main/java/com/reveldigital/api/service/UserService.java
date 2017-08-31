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

import com.reveldigital.api.RequestException;
import com.reveldigital.api.User;
import com.reveldigital.api.service.retrofit.UserInterface;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class UserService extends BaseService<UserInterface> {

    public List<User> getUsers() throws RequestException, IOException {
        return verifyResponse(wrapper.getUsers().execute());
    }

    public void getUsers(Callback<List<User>> callback) throws RequestException {
        wrapper.getUsers().enqueue(callback);
    }

    public User getUser(String id) throws RequestException, IOException {
        return verifyResponse(wrapper.getUser(id).execute());
    }

    public void getUser(String id, Callback<User> callback) throws RequestException {
        wrapper.getUser(id).enqueue(callback);
    }

    public Void updateUser(User user) throws RequestException, IOException {
        return verifyResponse(wrapper.updateUser(user.getId(), user).execute());
    }

    public void updateUser(User user, Callback<Void> callback) throws RequestException {
        wrapper.updateUser(user.getId(), user).enqueue(callback);
    }

    public User createUser(User user) throws RequestException, IOException {
        if (user.getUserName() == null)
            throw new IllegalArgumentException("Username is required");
        if (user.getPassword() == null)
            throw new IllegalArgumentException("Password is required");
        if (user.getEmail() == null)
            throw new IllegalArgumentException("Email is required");

        return verifyResponse(wrapper.createUser(user).execute());
    }

    public void createUser(User user, Callback<User> callback) throws RequestException {
        if (user.getUserName() == null)
            throw new IllegalArgumentException("Username is required");
        if (user.getPassword() == null)
            throw new IllegalArgumentException("Password is required");
        if (user.getEmail() == null)
            throw new IllegalArgumentException("Email is required");

        wrapper.createUser(user).enqueue(callback);
    }

    public static class Builder extends BaseService.Builder {

        public UserService build() {
            UserService service = new UserService();
            service.wrapper = build(UserInterface.class);
            return service;
        }
    }
}
