/**
 * @(#)PassedQuiz.java 3/18/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/18/16
 */
public class PassedQuiz {
    private QuizImpl m_quiz;
    private int m_mark;

    public QuizImpl getQuiz() {
        return m_quiz;
    }

    public void setQuiz(QuizImpl quiz) {
        m_quiz = quiz;
    }

    public int getMark() {
        return m_mark;
    }

    public void setMark(int mark) {
        m_mark = mark;
    }
}
