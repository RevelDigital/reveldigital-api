package com.reveldigital.api.test;

import com.reveldigital.api.Schedule;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.ScheduleService;
import junit.framework.TestCase;

import java.util.List;


/**
 * Created by Mike on 6/5/2014.
 */
public class ScheduleServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetSchedules() throws Exception, RequestException {
        ScheduleService service = new ScheduleService(client);
        List<Schedule> ret = service.getSchedules();
        assertTrue(ret.size() > 0);
    }

    public void testGetSchedule() throws Exception, RequestException {
        ScheduleService service = new ScheduleService(client);
        Schedule ret = service.getSchedule("qIQ-2l5brWw");
        assertTrue(ret.getName().equals("Internal"));
    }
}
