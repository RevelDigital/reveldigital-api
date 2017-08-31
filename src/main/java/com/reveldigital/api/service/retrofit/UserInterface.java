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

import com.reveldigital.api.RequestException;
import com.reveldigital.api.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_USERS;

/**
 * Created by Mike on 1/5/2015.
 */
public interface UserInterface {

    @GET(SEGMENT_USERS)
    Call<List<User>> getUsers() throws RequestException;

    @GET(SEGMENT_USERS + "/{id}")
    Call<User> getUser(@Path("id") String id) throws RequestException;

    @PUT(SEGMENT_USERS + "/{id}")
    Call<Void> updateUser(@Path("id") String id, @Body User user) throws RequestException;

    @POST(SEGMENT_USERS)
    Call<User> createUser(@Body User user) throws RequestException;
}
