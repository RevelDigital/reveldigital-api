package com.reveldigital.api.test;

import com.reveldigital.api.Command;
import com.reveldigital.api.Device;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.DeviceService;
import junit.framework.TestCase;

import java.util.Date;
import java.util.List;


public class DeviceServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetDevices() throws Exception, RequestException {
        DeviceService service = new DeviceService(client);
        List<Device> devices = service.getDevices();
        assertTrue(devices.size() > 0);
    }

    public void testGetDevicesByType() throws Exception, RequestException {
        DeviceService service = new DeviceService(client);
        List<Device> devices = service.getDevicesByType("AdvMedia");
        assertTrue(devices.size() > 0);
    }

    public void testGetDevice() throws Exception, RequestException {
        DeviceService service = new DeviceService(client);
        Device device = service.getDevice("1Xrq-E6H7U8");
        assertTrue(device.getName().equals("Internal Dev"));
    }

    public void testPostCommands() throws Exception, RequestException {
        DeviceService service = new DeviceService(client);
        service.postCommands("1Xrq-E6H7U8", new Command().setName("abc").setArg("def"));
    }

    public void testUpdateDevice() throws Exception {
        DeviceService service = new DeviceService(client);
        Device device = service.getDevice("1Xrq-E6H7U8");
        device.setTags("ABC");
        device.setLastService(new Date());
        service.updateDevice(device);
        assertTrue(device.getTags().equals("ABC"));
    }
}