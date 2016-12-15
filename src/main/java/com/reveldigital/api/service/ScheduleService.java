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

import com.reveldigital.api.Group;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.Schedule;
import com.reveldigital.api.service.retrofit.ScheduleInterface;
import retrofit2.Callback;

import java.io.IOException;
import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class ScheduleService extends BaseService<ScheduleInterface> {

    public List<Schedule> getSchedules() throws RequestException, IOException {
        return verifyResponse(wrapper.getSchedules().execute());
    }

    public void getSchedules(Callback<List<Schedule>> callback) throws RequestException {
        wrapper.getSchedules().enqueue(callback);
    }

    public Schedule getSchedule(String id) throws RequestException, IOException {
        return verifyResponse(wrapper.getSchedule(id).execute());
    }

    public void getSchedule(String id, Callback<Schedule> callback) throws RequestException {
        wrapper.getSchedule(id).enqueue(callback);
    }

    public List<Group> getGroups() throws RequestException, IOException {
        return verifyResponse(wrapper.getGroups().execute());
    }

    public void getGroups(Callback<List<Group>> callback) throws RequestException {
        wrapper.getGroups().enqueue(callback);
    }

    public static class Builder extends BaseService.Builder {

        public ScheduleService build() {
            ScheduleService service = new ScheduleService();
            service.wrapper = build(ScheduleInterface.class);
            return service;
        }
    }
}
