/**
 * @(#)SupervisorController.java 3/22/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/22/16
 */
@Controller
@RequestMapping("/supervisor")
public class SupervisorController extends Utf8ContentController {
    @RequestMapping(method = RequestMethod.GET)
    public String profile() {

        return "supervisor/profile";
    }
}
