/**
 * @(#)AssignedQuiz.java 3/17/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

import java.time.LocalDateTime;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/17/16
 */
public class AssignedQuiz {
    private QuizImpl m_quiz;
    private LocalDateTime m_deadline;

    public QuizImpl getQuiz() {
        return m_quiz;
    }

    public void setQuiz(QuizImpl quiz) {
        m_quiz = quiz;
    }

    public LocalDateTime getDeadline() {
        return m_deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        m_deadline = deadline;
    }
}
