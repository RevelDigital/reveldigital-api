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

import com.reveldigital.api.RequestException;
import com.reveldigital.api.User;
import retrofit.Callback;
import retrofit.http.*;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_USERS;

/**
 * Created by Mike on 1/5/2015.
 */
public interface UserInterface {

    @GET(SEGMENT_USERS)
    List<User> getUsers() throws RequestException;

    @GET(SEGMENT_USERS)
    void getUsers(Callback<List<User>> callback) throws RequestException;

    @GET(SEGMENT_USERS + "/{id}")
    User getUser(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_USERS + "/{id}")
    void getUser(@Path("id") String id, Callback<User> callback) throws RequestException;

    @PUT(SEGMENT_USERS + "/{id}")
    User updateUser(@Path("id") String id, @Body User user) throws RequestException;

    @PUT(SEGMENT_USERS + "/{id}")
    void updateUser(@Path("id") String id, @Body User user, Callback<User> callback) throws RequestException;

    @POST(SEGMENT_USERS)
    User createUser(@Body User user) throws RequestException;

    @POST(SEGMENT_USERS)
    void createUser(@Body User user, Callback<User> callback) throws RequestException;
}
