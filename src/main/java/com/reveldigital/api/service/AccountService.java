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

import com.reveldigital.api.Account;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.service.retrofit.AccountInterface;
import retrofit2.Callback;
import retrofit2.http.Body;

import java.io.IOException;

/**
 * Created by Mike on 1/5/2015.
 */
public class AccountService extends BaseService<AccountInterface> {

    public Account getAccount() throws RequestException, IOException {
        return verifyResponse(wrapper.getAccount().execute());
    }

    public void getAccount(Callback<Account> callback) throws RequestException {
        wrapper.getAccount().enqueue(callback);
    }

    public Void updateAccount(@Body Account account) throws RequestException, IOException {
        return verifyResponse(wrapper.updateAccount(account).execute());
    }

    public void updateAccount(@Body Account account, Callback<Void> callback) throws RequestException {
        wrapper.updateAccount(account).enqueue(callback);
    }

    public static class Builder extends BaseService.Builder {

        public AccountService build() {
            AccountService service = new AccountService();
            service.wrapper = build(AccountInterface.class);
            return service;
        }
    }
}
