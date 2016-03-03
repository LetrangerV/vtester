/**
 * @(#)AddQuizController.java 3/1/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
@Controller
@RequestMapping(path = "/quiz")
public class QuizController {
    @RequestMapping(method = RequestMethod.POST)
    public void addTypes(@RequestParam(name = "question_type", required = true) String[] questionTypes) {
        Arrays.asList(questionTypes).forEach(System.out::println);
//        question_text:
//        option_text:
//        is-right
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "quiz";
    }
}
