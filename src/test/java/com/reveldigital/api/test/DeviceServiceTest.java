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

package com.reveldigital.api.test;

import com.reveldigital.api.Command;
import com.reveldigital.api.CommandSet;
import com.reveldigital.api.Device;
import com.reveldigital.api.Group;
import com.reveldigital.api.service.DeviceService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class DeviceServiceTest {

    DeviceService service;

    @Before
    public void initialize() {
        service = new DeviceService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetDevices() throws Exception {
        List<Device> devices = service.getDevices();
        assertTrue(devices.size() > 0);
    }

    @Test
    public void testGetDevicesByType() throws Exception {
        List<Device> devices = service.getDevices("AdvMedia");
        assertTrue(devices.size() > 0);
    }

    @Test
    public void testGetDevice() throws Exception {
        Device device = service.getDevice("1Xrq-E6H7U8");
        assertTrue(device.getName().equals("Internal Dev"));
    }

    @Test
    public void testGetGroups() throws Exception {
        List<Group> groups = service.getGroups();
        assertTrue(groups.size() > 0);
    }

    @Test
    public void testPostCommands() throws Exception {
        service.postCommands("1Xrq-E6H7U8", Arrays.asList(new Command().setName("abc").setArg("def")));
    }

    @Test
    public void testPostCommandSets() throws Exception {
        service.postCommands(Arrays.asList(new CommandSet().setDeviceId("KGnhx4D6uxk").setCommands(
                Arrays.asList(new Command().setName("abc").setArg("def")))));
    }

    @Test
    public void testUpdateDevice() throws Exception {
        Device device = service.getDevice("1Xrq-E6H7U8");
        device.setTags("ABC");
        device.setLastService(new Date());
        service.updateDevice(device);
        assertTrue(device.getTags().equals("ABC"));
    }
}