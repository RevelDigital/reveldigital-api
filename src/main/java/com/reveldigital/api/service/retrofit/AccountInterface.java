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

import com.reveldigital.api.Account;
import com.reveldigital.api.RequestException;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

import static com.reveldigital.api.IConstants.SEGMENT_ACCOUNT;

/**
 * Created by Mike on 1/5/2015.
 */
public interface AccountInterface {

    @GET(SEGMENT_ACCOUNT)
    Call<Account> getAccount() throws RequestException;

    @PUT(SEGMENT_ACCOUNT)
    Call<Void> updateAccount(@Body Account account) throws RequestException;
}
