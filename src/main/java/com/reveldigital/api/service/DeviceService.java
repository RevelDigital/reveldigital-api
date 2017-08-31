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

import com.reveldigital.api.*;
import com.reveldigital.api.service.retrofit.DeviceInterface;
import okhttp3.ResponseBody;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class DeviceService extends BaseService<DeviceInterface> {

    public List<Device> getDevices() throws RequestException, IOException {
        return verifyResponse(wrapper.getDevices(null).execute());
    }

    public void getDevices(Callback<List<Device>> callback) throws RequestException {
        wrapper.getDevices(null).enqueue(callback);
    }

    public List<Device> getDevices(String deviceType) throws RequestException, IOException {
        return verifyResponse(wrapper.getDevices(deviceType).execute());
    }

    public void getDevices(String deviceType, Callback<List<Device>> callback) throws RequestException {
        wrapper.getDevices(deviceType).enqueue(callback);
    }

    public Device getDevice(String id) throws RequestException, IOException {
        return verifyResponse(wrapper.getDevice(id).execute());
    }

    public void getDevice(String id, Callback<Device> callback) throws RequestException {
        wrapper.getDevice(id).enqueue(callback);
    }

    public List<Group> getGroups() throws RequestException, IOException {
        return verifyResponse(wrapper.getGroups().execute());
    }

    public void getGroups(Callback<List<Group>> callback) throws RequestException {
        wrapper.getGroups().enqueue(callback);
    }

    public Void updateDevice(Device device) throws RequestException, IOException {
        return verifyResponse(wrapper.updateDevice(device.getId(), device).execute());
    }

    public void updateDevice(Device device, Callback<Void> callback) throws RequestException {
        wrapper.updateDevice(device.getId(), device).enqueue(callback);
    }

    public Device createDevice(String activationCode, Device device) throws RequestException, IOException {
        return verifyResponse(wrapper.createDevice(activationCode, device).execute());
    }

    public void createDevice(String activationCode, Device device, Callback<Device> callback) throws RequestException {
        wrapper.createDevice(activationCode, device).enqueue(callback);
    }

    public void postCommands(String id, List<Command> commands) throws RequestException, IOException {
        verifyResponse(wrapper.postCommands(id, commands).execute());
    }

    public void postCommands(String id, List<Command> commands, Callback<ResponseBody> callback) throws RequestException {
        wrapper.postCommands(id, commands).enqueue(callback);
    }

    public void postCommands(List<CommandSet> commandSets) throws RequestException, IOException {
        verifyResponse(wrapper.postCommands(commandSets).execute());
    }

    public void postCommands(List<CommandSet> commandSets, Callback<ResponseBody> callback) throws RequestException {
        wrapper.postCommands(commandSets).enqueue(callback);
    }

    public static class Builder extends BaseService.Builder {

        public DeviceService build() {
            DeviceService service = new DeviceService();
            service.wrapper = build(DeviceInterface.class);
            return service;
        }
    }
}
