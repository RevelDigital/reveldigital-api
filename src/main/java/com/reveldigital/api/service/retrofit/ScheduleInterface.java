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

import com.reveldigital.api.Group;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.Schedule;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

import static com.reveldigital.api.IConstants.SEGMENT_PLAYLISTS;
import static com.reveldigital.api.IConstants.SEGMENT_SCHEDULES;

/**
 * Created by Mike on 1/5/2015.
 */
public interface ScheduleInterface {

    @GET(SEGMENT_SCHEDULES)
    Call<List<Schedule>> getSchedules() throws RequestException;

    @GET(SEGMENT_SCHEDULES + "/{id}")
    Call<Schedule> getSchedule(@Path("id") String id) throws RequestException;

    @GET(SEGMENT_SCHEDULES + "/groups")
    Call<List<Group>> getGroups() throws RequestException;
}
