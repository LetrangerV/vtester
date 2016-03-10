/**
 * @(#)AddQuizController.java 3/1/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.controller;

import com.letrangerv.vtester.dao.QuizDto;
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

        //todo save in db via service layer. maybe convert to domain object first
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        return "quiz"; //todo redirect
    }
}
