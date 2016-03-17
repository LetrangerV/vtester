/**
 * @(#)OneAnswerQuestion.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class OneAnswerQuestion extends Entity implements Question {
    private String questionText;
    private List<AnswerOption> m_options;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptions(List<AnswerOption> options) {
        m_options = options;
    }

    public List<AnswerOption> getOptions() {
        return m_options;
    }

    @Override
    public int evaluate() {

        return 0;
    }

    @Override
    public int getMaxScore() {
        return 1;
    }
}
