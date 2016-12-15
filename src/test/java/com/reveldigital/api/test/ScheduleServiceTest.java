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

import com.reveldigital.api.Group;
import com.reveldigital.api.Schedule;
import com.reveldigital.api.service.ScheduleService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class ScheduleServiceTest {

    ScheduleService service;

    @Before
    public void initialize() {
        service = new ScheduleService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetSchedules() throws Exception {
        List<Schedule> ret = service.getSchedules();
        assertTrue(ret.size() > 0);
    }

    @Test
    public void testGetSchedule() throws Exception {
        Schedule ret = service.getSchedule("qIQ-2l5brWw");
        assertTrue(ret.getName().equals("Internal"));
    }

    @Test
    public void testGetGroups() throws Exception {
        List<Group> groups = service.getGroups();
        assertTrue(groups.size() > 0);
    }
}
