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

import com.reveldigital.api.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_DEVICES;

/**
 * Created by Mike on 1/5/2015.
 */
public interface DeviceInterface {

    @GET(SEGMENT_DEVICES)
    Call<List<Device>> getDevices(@Query("device_type_id") String deviceType) throws RequestException;

    @GET(SEGMENT_DEVICES + "/{id}")
    Call<Device> getDevice(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_DEVICES + "/groups")
    Call<List<Group>> getGroups() throws RequestException;

    @PUT(SEGMENT_DEVICES + "/{id}")
    Call<Void> updateDevice(@Path("id") String id, @Body Device device) throws RequestException;

    @POST(SEGMENT_DEVICES)
    Call<Device> createDevice(@Query("activation_code") String activationCode, @Body Device device) throws RequestException;

    @POST(SEGMENT_DEVICES + "/{id}/commands")
    Call<ResponseBody> postCommands(@Path("id") String id, @Body List<Command> commands) throws RequestException;

    @POST(SEGMENT_DEVICES + "/commands")
    Call<ResponseBody> postCommands(@Body List<CommandSet> commandSets) throws RequestException;

}
