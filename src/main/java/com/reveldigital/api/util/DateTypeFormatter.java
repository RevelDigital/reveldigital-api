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

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Formatter for date formats present in the RevelDigital API.
 */
public class DateTypeFormatter implements JsonDeserializer<Date>,
        JsonSerializer<Date> {

    private final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //$NON-NLS-1$
    private final String DATE_ONLY_FORMAT = "yyyy-MM-dd"; //$NON-NLS-1$
    private final String TIME_ONLY_FORMAT = "HH:mm:ss"; //$NON-NLS-1$

    private final DateFormat[] formats;

    /**
     * Create date formatter
     */
    public DateTypeFormatter() {
        formats = new DateFormat[3];
        formats[0] = new SimpleDateFormat(DATE_TIME_FORMAT);
        formats[1] = new SimpleDateFormat(DATE_ONLY_FORMAT);
        formats[2] = new SimpleDateFormat(TIME_ONLY_FORMAT);
    }

    public Date deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {
        JsonParseException exception = null;
        final String value = json.getAsString();
        for (DateFormat format : formats)
            try {
                synchronized (format) {
                    return format.parse(value);
                }
            } catch (ParseException e) {
                exception = new JsonParseException(e);
            }
        throw exception;
    }

    public JsonElement serialize(Date date, Type type,
                                 JsonSerializationContext context) {
        final DateFormat primary = formats[0];
        String formatted;
        synchronized (primary) {
            formatted = primary.format(date);
        }
        return new JsonPrimitive(formatted);
    }
}