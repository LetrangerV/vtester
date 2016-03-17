/**
 * @(#)DateTimeConverter.java 3/17/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
public final class DateTimeConverter {
    private static ZoneOffset UTC_ZONE = ZoneOffset.UTC;

    private DateTimeConverter(){}

    public static Date LdtToDate(LocalDateTime ldt) {
        Instant instant = ldt.toInstant(UTC_ZONE);
        return Date.from(instant);
    }

    public static LocalDateTime DateToLdt(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, UTC_ZONE);
    }
}
