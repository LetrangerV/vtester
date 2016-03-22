package com.letrangerv.vtester.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/22/16
 */
@ControllerAdvice
@SuppressWarnings("unused")
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final String handle500() {
        return "error/500";
    }
}
