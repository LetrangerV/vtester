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
    public final String get() {
        return "option";
    }
}
