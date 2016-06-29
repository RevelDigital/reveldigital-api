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

import com.google.gson.GsonBuilder;
import com.reveldigital.api.RequestError;
import com.reveldigital.api.RequestException;
import com.reveldigital.api.util.ByteArrayTypeAdapter;
import com.reveldigital.api.util.DateTypeFormatter;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static com.reveldigital.api.IConstants.URL_API;

/**
 * Created by Mike on 1/2/2015.
 */
public abstract class BaseService<T> {

    protected T wrapper;

    protected static Retrofit retrofit;

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

            if (retrofit == null) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Date.class, new DateTypeFormatter());
                gsonBuilder.registerTypeHierarchyAdapter(byte[].class,
                        new ByteArrayTypeAdapter());
                gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);

                OkHttpClient httpClient = new OkHttpClient.Builder()
                        .readTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .addInterceptor(new Interceptor() {
                            @Override
                            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                                Request original = chain.request();
                                Request request = original.newBuilder()
                                        .url(original.url().newBuilder().addQueryParameter("api_key", getApiKey()).build())
                                        .method(original.method(), original.body())
                                        .build();
                                return chain.proceed(request);
                            }
                        }).build();

                retrofit = new Retrofit.Builder()
                        .baseUrl(URL_API)
                        .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                        .client(httpClient)
                        .build();
            }

            return retrofit.create(type);
        }
    }

    protected static <T> T verifyResponse(Response<T> response) throws RequestException {
        if (response != null && !response.isSuccessful() && response.errorBody() != null) {
            Converter<ResponseBody, RequestError> converter =
                    retrofit.responseBodyConverter(RequestError.class, new Annotation[0]);

            RequestError error;
            try {
                error = converter.convert(response.errorBody());
            } catch (IOException e) {
                throw new RequestException(response.code(), response.message());
            }

            throw new RequestException(response.code(), error);
        }

        if (response == null) {
            return null;
        }
        return response.body();
    }
}
