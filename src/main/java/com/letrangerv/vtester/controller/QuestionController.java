package com.letrangerv.vtester.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/4/16
 */
@Controller
@RequestMapping("/question")
public class QuestionController extends Utf8ContentController {
    @RequestMapping(method = RequestMethod.GET)
    public final String get() {
        return "question";
    }
}
