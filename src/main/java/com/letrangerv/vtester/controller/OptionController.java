/**
 * @(#)OptionController.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
@Controller
@RequestMapping("/option")
public class OptionController extends Utf8ContentController {
    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "option";
    }
}
