package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Command;
import com.reveldigital.api.Device;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_COMMANDS;
import static com.reveldigital.api.client.IConstants.SEGMENT_DEVICES;

/**
 * Created by Mike on 6/4/2014.
 */
public class DeviceService extends RevelService {

    /**
     * Create device service
     */
    public DeviceService() {
        super();
    }

    /**
     * Create device service for client
     *
     * @param client
     */
    public DeviceService(RevelClient client) {
        super(client);
    }

    /**
     * Get all devices
     *
     * @return
     * @throws java.io.IOException
     */
    public List<Device> getDevices() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_DEVICES);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Device>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get devices by type
     *
     * @param deviceType
     * @return
     * @throws java.io.IOException
     */
    public List<Device> getDevicesByType(String deviceType) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_DEVICES);

        RevelRequest request = createRequest(new HashMap<String, String>() {
            {
                put("api_key", getApiKey());
            }
        });
        request.setUri(uri);
        request.setType(new TypeToken<List<Device>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get device by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public Device getDevice(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_DEVICES);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Device>>() {
        }.getType());

        List<Device> devices = client.get(request);
        if (devices == null || devices.size() == 0) {
            return null;
        } else {
            return devices.get(0);
        }
    }

    /**
     * Update device
     *
     * @param device
     * @return
     * @throws java.io.IOException
     */
    public Device updateDevice(Device device) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_DEVICES);
        uri.append('/').append(device.getId());

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(Device.class);
        request.setBody(device);

        return client.put(request);
    }

    /**
     * Post a set of commands to a device
     *
     * @param id
     * @param commands
     * @throws java.io.IOException
     */
    public void postCommands(String id, Command... commands) throws IOException {
        if (commands == null)
            throw new IllegalArgumentException("Commands cannot be null");
        if (commands.length == 0)
            throw new IllegalArgumentException("Commands cannot be empty");

        StringBuilder uri = new StringBuilder(SEGMENT_DEVICES);
        uri.append('/').append(id);
        uri.append(SEGMENT_COMMANDS);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setBody(Arrays.asList(commands));
        request.setType(new TypeToken<List<Device>>() {
        }.getType());

        client.post(request);
    }
}
