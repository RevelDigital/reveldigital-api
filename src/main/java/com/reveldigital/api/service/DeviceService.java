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

package com.reveldigital.api.service;

import com.reveldigital.api.Command;
import com.reveldigital.api.Device;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.service.retrofit.DeviceInterface;
import retrofit.Callback;
import retrofit.client.Response;

import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class DeviceService extends BaseService<DeviceInterface> {

    public List<Device> getDevices() throws RequestException {
        return wrapper.getDevices(null);
    }

    public void getDevices(Callback<List<Device>> callback) throws RequestException {
        wrapper.getDevices(null, callback);
    }

    public List<Device> getDevices(String deviceType) throws RequestException {
        return wrapper.getDevices(deviceType);
    }

    public void getDevices(String deviceType, Callback<List<Device>> callback) throws RequestException {
        wrapper.getDevices(deviceType, callback);
    }

    public Device getDevice(String id) throws RequestException {
        return wrapper.getDevice(id);
    }

    public void getDevice(String id, Callback<Device> callback) throws RequestException {
        wrapper.getDevice(id, callback);
    }

    public Device updateDevice(Device device) throws RequestException {
        return wrapper.updateDevice(device.getId(), device);
    }

    public void updateDevice(Device device, Callback<Device> callback) throws RequestException {
        wrapper.updateDevice(device.getId(), device, callback);
    }

    public Device createDevice(String activationCode, Device device) throws RequestException {
        return wrapper.createDevice(activationCode, device);
    }

    public void createDevice(String activationCode, Device device, Callback<Device> callback) throws RequestException {
        wrapper.createDevice(activationCode, device, callback);
    }

    public Response postCommands(String id, List<Command> commands) throws RequestException {
        return wrapper.postCommands(id, commands);
    }

    public void postCommands(String id, List<Command> commands, Callback<Response> callback) throws RequestException {
        wrapper.postCommands(id, commands, callback);
    }

    public static class Builder extends BaseService.Builder {

        public DeviceService build() {
            DeviceService service = new DeviceService();
            service.wrapper = build(DeviceInterface.class);
            return service;
        }
    }
}
