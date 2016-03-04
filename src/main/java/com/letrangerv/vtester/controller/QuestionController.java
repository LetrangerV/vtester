/**
 * @(#)QuestionController.java 3/4/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import freemarker.template.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/4/16
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam final int number) {
        System.out.println("number " + number);
//        Configuration ftlCfg = new Configuration();
                           //todo add param
//        ftlCfg.getTemplate("WEB-INF/question.ftl");

        return "question";
    }

    @ModelAttribute
    public void setVaryResponseHeader(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
    }
}
