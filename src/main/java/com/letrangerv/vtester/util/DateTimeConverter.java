package com.letrangerv.vtester.util;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
@Component
@SuppressWarnings("unused")
public final class DateTimeConverter {
    private static final ZoneOffset UTC_ZONE = ZoneOffset.UTC;

    private DateTimeConverter() { }

    public static Date ldtToDate(final LocalDateTime ldt) {
        Instant instant = ldt.toInstant(UTC_ZONE);
        return Date.from(instant);
    }

    public static LocalDateTime dateToLdt(final Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, UTC_ZONE);
    }
}
