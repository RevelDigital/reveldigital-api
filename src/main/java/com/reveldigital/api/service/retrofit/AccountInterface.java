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

package com.reveldigital.api.service.retrofit;

import com.reveldigital.api.Account;
import com.reveldigital.api.RequestException;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;

import static com.reveldigital.api.IConstants.SEGMENT_ACCOUNT;

/**
 * Created by Mike on 1/5/2015.
 */
public interface AccountInterface {

    @GET(SEGMENT_ACCOUNT)
    Account getAccount() throws RequestException;

    @GET(SEGMENT_ACCOUNT)
    void getAccount(Callback<Account> callback) throws RequestException;

    @PUT(SEGMENT_ACCOUNT)
    Account updateAccount(@Body Account account) throws RequestException;

    @PUT(SEGMENT_ACCOUNT)
    void updateAccount(@Body Account account, Callback<Account> callback) throws RequestException;
}
