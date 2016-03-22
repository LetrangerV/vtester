/**
 * @(#)OneAnswerQuestionService.java 3/21/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.OneAnswerQuestion;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/21/16
 */
public interface OneAnswerQuestionService {
    List<OneAnswerQuestion> getByQuiz(String title);
}
