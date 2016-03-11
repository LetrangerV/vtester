/**
 * @(#)QuizAssembler.java 3/10/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import com.letrangerv.vtester.domain.QuizImpl;
import org.springframework.stereotype.Component;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/10/16
 */
@Component
public interface QuizAssembler {
    QuizImpl toQuiz(QuizDto quizDto);
    QuizDto toQuizDto(QuizImpl quiz);
}
