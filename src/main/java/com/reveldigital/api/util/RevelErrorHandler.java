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

package com.reveldigital.api.util;

import com.reveldigital.api.RequestError;
import com.reveldigital.api.RequestException;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Created by Mike on 1/5/2015.
 */
public class RevelErrorHandler implements ErrorHandler {
    @Override
    public Throwable handleError(RetrofitError cause) {
        if (cause.getResponse() == null) {
            return new RequestException("No response from server");
        } else {
            try {
                RequestError errorResponse = (RequestError) cause.getBodyAs(RequestError.class);
                return new RequestException(cause.getResponse().getStatus(), errorResponse.getDescription());
            } catch (Exception ex) {
                return new RequestException(cause.getResponse().getStatus(), cause.getResponse().getReason());
            }
        }
    }
}
