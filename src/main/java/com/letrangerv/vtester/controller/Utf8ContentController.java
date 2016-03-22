package com.letrangerv.vtester.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;

/**
 * All controllers returning .ftl templates as response must extend this class.
 * Otherwise there will be encoding issues.
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
public abstract class Utf8ContentController {
    @ModelAttribute
    public final void setVaryResponseHeader(final HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
    }
}
