/**
 * @(#)ControllerExceptionHandler.java 3/22/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/22/16
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handle500() {
        return "error/500";
    }
}
