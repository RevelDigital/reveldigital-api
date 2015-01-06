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

import com.reveldigital.api.Account;
import com.reveldigital.api.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Mike on 6/5/2014.
 */
public class AccountServiceTest {

    AccountService service;

    @Before
    public void initialize() {
        service = new AccountService.Builder()
                .setApiKey(IConstants.API_KEY)
                .build();
    }

    @Test
    public void testGetAccount() throws Exception {
        Account account = service.getAccount();
        assertTrue("Moorhead".equals(account.getCity()));
    }

    @Test
    public void testGetAccountAsync() throws Exception {
        final CountDownLatch lock = new CountDownLatch(1);

        service.getAccount(new Callback<Account>() {
            @Override
            public void success(Account account, Response response) {
                assertTrue("Moorhead".equals(account.getCity()));
                lock.countDown();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        assert (lock.await(2000, TimeUnit.MILLISECONDS) == true);
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account = service.getAccount();
        account.setFax("333-444-5555");
        service.updateAccount(account);
        assertTrue(account.getFax().equals("333-444-5555"));
    }
}