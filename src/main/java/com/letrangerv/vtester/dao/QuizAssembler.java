/**
 * @(#)QuizAssembler.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.dao;

import com.letrangerv.vtester.domain.Quiz;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
public interface QuizAssembler {
    Quiz dtoToQuiz(QuizDto quizDto);
    QuizDto quizToDto(Quiz quiz);
}
