package com.reveldigital.api.test;

import com.reveldigital.api.User;
import com.reveldigital.api.client.RequestException;
import com.reveldigital.api.client.RevelClient;
import com.reveldigital.api.service.UserService;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class UserServiceTest extends TestCase {

    RevelClient client;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.client = new RevelClient();
        client.setApiKey(IConstants.API_KEY);
    }

    public void testGetUsers() throws Exception, RequestException {
        UserService service = new UserService(client);
        List<User> ret = service.getUsers();
        assertTrue(ret.size() > 0);
    }

    public void testGetUser() throws Exception, RequestException {
        UserService service = new UserService(client);
        User ret = service.getUser("IrcEv6dviZU");
        assertTrue(ret.getFirstName().equals("Catalyst"));
    }
}
