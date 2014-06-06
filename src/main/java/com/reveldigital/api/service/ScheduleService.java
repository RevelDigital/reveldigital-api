package com.reveldigital.api.service;

import com.google.gson.reflect.TypeToken;
import com.reveldigital.api.Schedule;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.client.RevelRequest;

import java.io.IOException;
import java.util.List;

import static com.reveldigital.api.client.IConstants.SEGMENT_SCHEDULES;

/**
 * Created by Mike on 6/5/2014.
 */
public class ScheduleService extends RevelService {

    /**
     * Create device service
     */
    public ScheduleService() {
        super();
    }

    /**
     * Create schedule service for client
     *
     * @param client
     */
    public ScheduleService(RevelClient client) {
        super(client);
    }

    /**
     * Get all schedules
     *
     * @return
     * @throws java.io.IOException
     */
    public List<Schedule> getSchedules() throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_SCHEDULES);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Schedule>>() {
        }.getType());

        return client.get(request);
    }

    /**
     * Get schedule by id
     *
     * @param id
     * @return
     * @throws java.io.IOException
     */
    public Schedule getSchedule(String id) throws IOException {
        StringBuilder uri = new StringBuilder(SEGMENT_SCHEDULES);
        uri.append('/').append(id);

        RevelRequest request = createRequest();
        request.setUri(uri);
        request.setType(new TypeToken<List<Schedule>>() {
        }.getType());

        List<Schedule> ret = client.get(request);
        if (ret == null || ret.size() == 0) {
            return null;
        } else {
            return ret.get(0);
        }
    }
}
