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

package com.reveldigital.api.service;

import com.google.gson.GsonBuilder;
import com.reveldigital.api.util.ByteArrayTypeAdapter;
import com.reveldigital.api.util.DateTypeFormatter;
import com.reveldigital.api.util.RevelErrorHandler;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import java.util.Date;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static com.reveldigital.api.IConstants.URL_API;

/**
 * Created by Mike on 1/2/2015.
 */
public abstract class BaseService<T> {

    protected T wrapper;

    public abstract static class Builder {

        private String apiKey;

        public String getApiKey() {
            return apiKey;
        }

        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public abstract <T> T build();

        public <T> T build(Class<T> type) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateTypeFormatter());
            gsonBuilder.registerTypeHierarchyAdapter(byte[].class,
                    new ByteArrayTypeAdapter());
            gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);

            RestAdapter restAdapter = new RestAdapter.Builder()
                    //.setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                    .setErrorHandler(new RevelErrorHandler())
                    .setEndpoint(URL_API)
                    .setClient(new OkClient(new OkHttpClient()))
                    .setConverter(new GsonConverter(gsonBuilder.create()))
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade request) {
                            request.addQueryParam("api_key", getApiKey());
                        }
                    })
                    .build();
            return restAdapter.create(type);
        }
    }
}
