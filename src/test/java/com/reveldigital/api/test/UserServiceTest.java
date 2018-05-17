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

import com.reveldigital.api.User;
import com.reveldigital.api.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class UserServiceTest {

    UserService service;

    @Before
    public void initialize() {
        service = new UserService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetUsers() throws Exception {
        List<User> ret = service.getUsers();
        assertTrue(ret.size() > 0);
    }

    @Test
    public void testGetUser() throws Exception {
        User ret = service.getUser("qK1tXVolFYU3hz_1uDwYSA");
        assertTrue(ret.getFirstName().equals("Catalyst"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User ret = service.getUser("qK1tXVolFYU3hz_1uDwYSA");
        ret.setFirstName("Catalyst");
        service.updateUser(ret);
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
