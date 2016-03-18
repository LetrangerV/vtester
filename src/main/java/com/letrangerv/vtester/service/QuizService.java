/**
 * @(#)QuizService.java 3/16/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.service;

import com.letrangerv.vtester.domain.PassedQuiz;
import com.letrangerv.vtester.domain.QuizImpl;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/16/16
 */
public interface QuizService {
    void insertQuiz(QuizImpl quiz);
    List<QuizImpl> findAssignedQuizzes(String userName);

    List<PassedQuiz> findPassedQuizzes(String userName);
}
