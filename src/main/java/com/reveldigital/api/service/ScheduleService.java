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

import com.reveldigital.api.RequestException;
import com.reveldigital.api.Schedule;
import com.reveldigital.api.service.retrofit.ScheduleInterface;
import retrofit.Callback;

import java.util.List;

/**
 * Created by Mike on 1/5/2015.
 */
public class ScheduleService extends BaseService<ScheduleInterface> {

    public List<Schedule> getSchedules() throws RequestException {
        return wrapper.getSchedules();
    }

    public void getSchedules(Callback<List<Schedule>> callback) throws RequestException {
        wrapper.getSchedules(callback);
    }

    public Schedule getSchedule(String id) throws RequestException {
        return wrapper.getSchedule(id);
    }

    public void getSchedule(String id, Callback<Schedule> callback) throws RequestException {
        wrapper.getSchedule(id, callback);
    }

    public static class Builder extends BaseService.Builder {

        public ScheduleService build() {
            ScheduleService service = new ScheduleService();
            service.wrapper = build(ScheduleInterface.class);
            return service;
        }
    }
}
