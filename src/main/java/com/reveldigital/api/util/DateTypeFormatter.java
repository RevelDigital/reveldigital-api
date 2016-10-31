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

package com.reveldigital.api.util;

import com.google.gson.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Formatter for date formats present in the RevelDigital API.
 */
public class DateTypeFormatter implements JsonDeserializer<Date>,
        JsonSerializer<Date> {

    private final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //$NON-NLS-1$
    private final String DATE_ONLY_FORMAT = "yyyy-MM-dd"; //$NON-NLS-1$
    private final String TIME_ONLY_FORMAT = "HH:mm:ss"; //$NON-NLS-1$

    private final DateTimeFormatter[] formats;

    /**
     * Create date formatter
     */
    public DateTypeFormatter() {
        formats = new DateTimeFormatter[4];
        formats[0] = ISODateTimeFormat.dateTime(); //.withZone(DateTimeZone.UTC);
        formats[1] = new DateTimeFormatterBuilder().appendPattern(DATE_TIME_FORMAT).toFormatter();
        formats[2] = new DateTimeFormatterBuilder().appendPattern(DATE_ONLY_FORMAT).toFormatter();
        formats[3] = new DateTimeFormatterBuilder().appendPattern(TIME_ONLY_FORMAT).toFormatter();
    }

    public Date deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context) throws JsonParseException {
        JsonParseException exception = null;
        final String value = json.getAsString();
        for (DateTimeFormatter format : formats)
            try {
                synchronized (format) {
                    return format.parseDateTime(value).toDate();
                }
            } catch (IllegalArgumentException e) {
                exception = new JsonParseException(e);
            }
        throw exception;
    }

    public JsonElement serialize(Date date, Type type,
                                 JsonSerializationContext context) {
        final DateTimeFormatter primary = formats[0];
        String formatted;
        synchronized (primary) {
            formatted = primary.print(new DateTime(date));
        }
        return new JsonPrimitive(formatted);
    }
}