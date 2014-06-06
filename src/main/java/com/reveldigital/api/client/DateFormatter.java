package com.reveldigital.api.client;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Formatter for date formats present in the RevelDigital API.
 */
public class DateFormatter implements JsonDeserializer<Date>,
        JsonSerializer<Date> {

    private final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //$NON-NLS-1$
    private final String DATE_ONLY_FORMAT = "yyyy-MM-dd"; //$NON-NLS-1$
    private final String TIME_ONLY_FORMAT = "HH:mm:ss"; //$NON-NLS-1$

    private final DateFormat[] formats;

    /**
     * Create date formatter
     */
    public DateFormatter() {
        formats = new DateFormat[3];
        formats[0] = new SimpleDateFormat(DATE_TIME_FORMAT);
        formats[1] = new SimpleDateFormat(DATE_ONLY_FORMAT);
        formats[2] = new SimpleDateFormat(TIME_ONLY_FORMAT);
        //final TimeZone timeZone = TimeZone.getTimeZone("Zulu"); //$NON-NLS-1$
        //for (DateFormat format : formats)
        //    format.setTimeZone(timeZone);
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