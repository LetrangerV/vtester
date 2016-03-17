/**
 * @(#)AddQuizController.java 3/1/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.persistence.QuizAssembler;
import com.letrangerv.vtester.persistence.QuizDto;
import com.letrangerv.vtester.domain.QuizImpl;
import com.letrangerv.vtester.service.QuizService;
import com.letrangerv.vtester.service.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/1/16
 */
@Controller
@RequestMapping(path = "/quiz")
public class QuizController extends Utf8ContentController {
    @Autowired
    private QuizAssembler m_quizAssembler;
    @Autowired
    private QuizService m_quizService;

    @RequestMapping(method = RequestMethod.POST)
    public void addTypes(
        @RequestParam(name = "question_type", required = true) String[] questionTypes,
        @RequestParam(name = "question_text", required = true) String[] questionText,
        @RequestParam(name = "option_text", required = true) String[] optionText,
        @RequestParam(name = "is-right-hid", required = true) boolean[] isRight,
        @RequestParam(name = "options-count", required = true) int[] numOfOptions
    ) {

        QuizDto quizDto = new QuizDto();
        quizDto.setQuestionTypes(questionTypes);
        quizDto.setQuestionText(questionText);
        quizDto.setOptionText(optionText);
        quizDto.setRightAnswer(isRight);
        quizDto.setNumberOfOptions(numOfOptions);

        QuizImpl quiz = m_quizAssembler.toQuiz(quizDto);
        m_quizService.insertQuiz(quiz);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "quiz"; //todo redirect
    }
}
