package com.reveldigital.api.test;

import com.reveldigital.api.User;
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

    public void testGetUsers() throws Exception {
        UserService service = new UserService(client);
        List<User> ret = service.getUsers();
        assertTrue(ret.size() > 0);
    }

    public void testGetUser() throws Exception {
        UserService service = new UserService(client);
        User ret = service.getUser("IrcEv6dviZU");
        assertTrue(ret.getFirstName().equals("Catalyst"));
    }

//    public void testCreateUser() throws Exception {
//        UserService service = new UserService(client);
//
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setRole("User");
//        user.setEmail("abc@xyz.com");
//
//        User ret = service.createUser("test-create-api", "password", user);
//        assertTrue(ret.getFirstName().equals("John"));
//    }
}
