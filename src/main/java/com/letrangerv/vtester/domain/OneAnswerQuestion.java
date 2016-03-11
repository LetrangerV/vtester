/**
 * @(#)OneAnswerQuestion.java 2/29/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.domain;

import java.util.Set;

/**
 * @author VStrokan
 * @version 1.0
 * @since 2/29/16
 */
public class OneAnswerQuestion implements Question {
    private String questionText;
    private Set<AnswerOption> m_optionSet;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptionSet(Set<AnswerOption> optionSet) {
        m_optionSet = optionSet;
    }

    public Set<AnswerOption> getOptionSet() {
        return m_optionSet;
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
