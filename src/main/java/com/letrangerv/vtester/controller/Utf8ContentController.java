/**
 * @(#)Utf8ContentController.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
public abstract class Utf8ContentController {
    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
    }
}
