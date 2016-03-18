/**
 * @(#)StudentController.java 3/18/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.service.QuizService;
import com.letrangerv.vtester.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
@Controller
@RequestMapping("/student")
public class StudentController extends Utf8ContentController {
    @Autowired
    private QuizService m_quizService;
    @Autowired
    private StudentService m_studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showMainPage(Model model, Principal principal) {
        List<QuizImpl> assignedQuizzes = m_quizService.findAssignedQuizzes(principal.getName());
        model.addAttribute("assignedQuizzes", assignedQuizzes);
        return "student/studentAllQuizzes";
    }
}
