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

import com.reveldigital.api.Command;
import com.reveldigital.api.Device;
import com.reveldigital.api.RequestException;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_DEVICES;

/**
 * Created by Mike on 1/5/2015.
 */
public interface DeviceInterface {

    @GET(SEGMENT_DEVICES)
    List<Device> getDevices(@Query("device_type_id") String deviceType) throws RequestException;

    @GET(SEGMENT_DEVICES)
    void getDevices(@Query("device_type_id") String deviceType, Callback<List<Device>> callback) throws RequestException;

    @GET(SEGMENT_DEVICES + "/{id}")
    Device getDevice(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_DEVICES + "/{id}")
    void getDevice(@Path("id") String id, Callback<Device> callback) throws RequestException;

    @PUT(SEGMENT_DEVICES + "/{id}")
    Device updateDevice(@Path("id") String id, @Body Device device) throws RequestException;

    @PUT(SEGMENT_DEVICES + "/{id}")
    void updateDevice(@Path("id") String id, @Body Device device, Callback<Device> callback) throws RequestException;

    @POST(SEGMENT_DEVICES)
    Device createDevice(@Query("activation_code") String activationCode, @Body Device device) throws RequestException;

    @POST(SEGMENT_DEVICES)
    void createDevice(@Query("activation_code") String activationCode, @Body Device device, Callback<Device> callback) throws RequestException;

    @POST(SEGMENT_DEVICES + "/{id}/commands")
    Response postCommands(@Path("id") String id, @Body List<Command> commands) throws RequestException;

    @POST(SEGMENT_DEVICES + "/{id}/commands")
    void postCommands(@Path("id") String id, @Body List<Command> commands, Callback<Response> callback) throws RequestException;
}
